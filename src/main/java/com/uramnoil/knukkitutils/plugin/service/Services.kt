package com.uramnoil.knukkitutils.plugin.service

import cn.nukkit.plugin.Plugin
import cn.nukkit.plugin.service.ServiceManager
import cn.nukkit.plugin.service.ServicePriority

inline fun <reified T> ServiceManager.register(provider: T, plugin: Plugin, priority: ServicePriority) = register(T::class.java, provider, plugin, priority)

inline fun <reified T> ServiceManager.cancel(provider: T) = cancel(T::class.java, provider)

inline fun <reified T> ServiceManager.getProvider() = getProvider(T::class.java)

inline fun <reified T> ServiceManager.getRegistrations() = getRegistrations(T::class.java)

inline fun <reified T> ServiceManager.isProvidedFor() = isProvidedFor(T::class.java)