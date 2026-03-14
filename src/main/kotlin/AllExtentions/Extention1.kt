package AllExtentions

import prof1.Person


inline fun <T, R> Iterable<T>.transformLineAE(trns: (T) -> R): List<R> {
    val fltr = mutableListOf<R>()
    for (a22 in this) {
        fltr.add(trns(a22))
    }
    return fltr
}

inline fun <T> Iterable<T>.filter(isSuitable: (T) -> Boolean): List<T> {
    val filtered = mutableListOf<T>()
    for (i in this) {
        if (isSuitable(i)) {
            filtered.add(i)
        }
    }
    return filtered
}

inline fun <T> Iterable<T>.fore4(code: (T) -> Unit) {
    for (a in this) {
        code(a)
    }

}

inline fun <T, R> T.myLet(code: (T) -> R): R {
    return code(this)
}

inline fun <T> T.myAlso(code: (T)-> Unit): T{
    code(this)
    return this
}