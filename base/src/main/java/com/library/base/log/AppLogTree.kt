package com.library.base.log

import timber.log.Timber

class AppLogTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        val className = super.createStackElementTag(element)?.split("$")?.get(0)
        return "($className.kt:${element.lineNumber})#${element.methodName}"
    }
}