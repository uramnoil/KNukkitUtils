package com.uramnoil.knukkitutils.plugin

import cn.nukkit.plugin.Plugin
import cn.nukkit.plugin.PluginManager

inline fun <reified T : Plugin>PluginManager.getPlugin(): Plugin? = plugins.values.filterIsInstance<T>().firstOrNull()

