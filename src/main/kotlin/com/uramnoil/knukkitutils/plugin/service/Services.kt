package com.uramnoil.knukkitutils.plugin.service

import cn.nukkit.Server
import cn.nukkit.plugin.Plugin
import cn.nukkit.plugin.service.RegisteredServiceProvider
import cn.nukkit.plugin.service.ServiceManager
import cn.nukkit.plugin.service.ServicePriority
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ProviderDelegate<T>(private val clazz: Class<T>) : ReadOnlyProperty<Any?, RegisteredServiceProvider<T>> {
    lateinit var provider: RegisteredServiceProvider<T>

    override fun getValue(thisRef: Any?, property: KProperty<*>): RegisteredServiceProvider<T> {
        if (!::provider.isInitialized) {
            provider = Server.getInstance().serviceManager.getProvider(clazz)
        }
        return provider
    }
}

class ServiceDelegate<T>(clazz: Class<T>) : ReadOnlyProperty<Any?, T> {
    private val service: T = Server.getInstance().serviceManager.getProvider(clazz).provider

    override fun getValue(thisRef: Any?, property: KProperty<*>) = service
}

inline fun <reified T> ServiceManager.register(provider: T, plugin: Plugin, priority: ServicePriority) =
    register(T::class.java, provider, plugin, priority)

inline fun <reified T> ServiceManager.cancel(provider: T) = cancel(T::class.java, provider)

inline fun <reified T> ServiceManager.getProvider() = this.getProvider(T::class.java)

inline fun <reified T> service() = ServiceDelegate(T::class.java)

inline fun <reified T> ServiceManager.getRegistrations() = getRegistrations(T::class.java)

inline fun <reified T> ServiceManager.isProvidedFor() = isProvidedFor(T::class.java)