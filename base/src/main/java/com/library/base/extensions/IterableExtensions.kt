package com.library.base.extensions

inline fun <T> Iterable<T>.nextAfterOrNull(predicate: (T) -> Boolean): T? {
    var found = false
    for (item in this) {
        if (found) return item
        if (predicate(item)) found = true
    }
    return null
}

val <T> T.exhaustive: T
    get() = this