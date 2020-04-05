@file:Suppress("unused")

package com.uramnoil.kotlib.schdule

import cn.nukkit.Server
import cn.nukkit.plugin.Plugin
import cn.nukkit.scheduler.TaskHandler

const val SECOND: Int = 20

const val MINUTE: Int = 20 * 60

const val HOUR: Int = 20 * 60 * 60


fun Plugin.delay(delay: Int, onRun: () -> Unit): TaskHandler =
	Server.getInstance().scheduler.scheduleDelayedTask(this, onRun, delay)

fun Plugin.repeat(period: Int, onRun: () -> Unit): TaskHandler =
	Server.getInstance().scheduler.scheduleRepeatingTask(this, onRun, period)

fun Plugin.delayedRepeating(delay: Int, period: Int, onRun: () -> Unit): TaskHandler =
	Server.getInstance().scheduler.scheduleDelayedRepeatingTask(this, onRun, delay, period)