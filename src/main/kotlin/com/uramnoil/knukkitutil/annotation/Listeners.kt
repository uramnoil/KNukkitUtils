package com.uramnoil.knukkitutil.annotation

import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement

@Target(AnnotationTarget.CLASS)
annotation class ListenerAnnotation

class ListenerAnnotationProcessor : AbstractProcessor() {
	override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
		val annotatedElements = roundEnv.getElementsAnnotatedWith(ListenerAnnotation::class.java)
		if (annotatedElements.isEmpty()) return false
		return true
	}
}