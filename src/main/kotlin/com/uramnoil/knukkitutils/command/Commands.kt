package com.uramnoil.knukkitutils.command

import cn.nukkit.Server
import cn.nukkit.command.Command
import cn.nukkit.command.CommandSender
import com.uramnoil.knukkitutils.plugin.CommandExecuter


@Suppress("unused")
fun command(command: String, execute: CommandExecuter) = command(command, "", execute)

fun command(command: String, description: String, execute: CommandExecuter) = command(command, description, "", execute)

fun command(command: String, description: String, usage: String, execute: CommandExecuter) =
	command(command, description, usage, setOf(), execute)

fun command(command: String, description: String, usage: String, aliases: Set<String>, execute: CommandExecuter) =
	command(command, description, usage, aliases, "", execute)

inline fun command(
	command: String,
	description: String = "",
	usage: String = "",
	aliases: Set<String> = setOf(),
	permission: String = "",
	crossinline execute: CommandExecuter
) {
	Server.getInstance().commandMap.register(
		command,
		object : Command(command, description, usage, aliases.toTypedArray()) {
			init {
				this.permission = permission
			}

			override fun execute(sender: CommandSender?, commandLabel: String?, args: Array<out String>?): Boolean {
				return if (testPermission(sender)) execute.invoke(sender!!, commandLabel!!, args!!) else false
			}
		})
}