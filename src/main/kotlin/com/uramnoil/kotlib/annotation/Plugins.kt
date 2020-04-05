package com.uramnoil.kotlib.annotation

import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement

@Target(AnnotationTarget.CLASS)
annotation class PluginAnnotation(val enable: Boolean = true)

class PluginAnnotationProcessor : AbstractProcessor() {
	companion object {
		const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "com.uramnoil.knukkitutils.annotation.generated"
	}

	override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
		roundEnv.getElementsAnnotatedWith(PluginAnnotation::class.java).forEach {

		}
	}
}