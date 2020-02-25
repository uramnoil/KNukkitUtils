package com.uramnoil.knukkitutils

import cn.nukkit.Player
import cn.nukkit.command.CommandSender

fun CommandSender.msg(msg: String) = sendMessage("msg")

fun Player.popup(popup: String) = sendPopup("popup")

fun Player.actionBar(title: String) = sendActionBar(title)

fun Player.actionBar(title: String, fadein: Int, duration: Int, fadeout: Int) = sendActionBar(title, fadein, duration, fadeout)

fun Player.tip(tip: String) = sendTip(tip)

fun Player.title(title: String) = sendTitle(title)

fun Player.title(title: String, subtitle: String) = sendTitle(title, subtitle)

fun Player.title(title: String, subtitle: String, fadein: Int, stay: Int, fadeout: Int) = sendTitle(title, subtitle, fadein, stay, fadeout)