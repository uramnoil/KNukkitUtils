package com.uramnoil.knukkitutils.config

import cn.nukkit.utils.Config
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringProperty(private val index: String, private val default: String) : ReadWriteProperty<Config, String> {
	override fun getValue(thisRef: Config, property: KProperty<*>): String {
		return thisRef.getString(index, default)
	}

	override fun setValue(thisRef: Config, property: KProperty<*>, value: String) {
		thisRef[index] = value
	}
}

class IntProperty(private val index: String, private val default: Int = 0) : ReadWriteProperty<Config, Int> {
	override fun getValue(thisRef: Config, property: KProperty<*>): Int {
		return thisRef.getInt(index, default)
	}

	override fun setValue(thisRef: Config, property: KProperty<*>, value: Int) {
		thisRef[index] = value
	}
}

class DoubleProperty(private val index: String, private val default: Double = 0.0) : ReadWriteProperty<Config, Double> {
	override fun getValue(thisRef: Config, property: KProperty<*>): Double {
		return thisRef.getDouble(index, default)
	}

	override fun setValue(thisRef: Config, property: KProperty<*>, value: Double) {
		thisRef[index] = value
	}
}

class BooleanProperty(private val index: String, private val default: Boolean = false) : ReadWriteProperty<Config, Boolean> {
	override fun getValue(thisRef: Config, property: KProperty<*>): Boolean {
		return thisRef.getBoolean(index, default)
	}

	override fun setValue(thisRef: Config, property: KProperty<*>, value: Boolean) {
		thisRef[index] = value
	}
}

@Suppress("unused")
fun Config.string(index: String, default: String = "") = StringProperty(index, default)

@Suppress("unused")
fun Config.boolean(index: String, default: Boolean = false) = BooleanProperty(index, default)

@Suppress("unused")
fun Config.int(index: String, default: Int = 0) = IntProperty(index, default)

@Suppress("unused")
fun Config.double(index: String, default: Double = 0.0) = DoubleProperty(index, default)