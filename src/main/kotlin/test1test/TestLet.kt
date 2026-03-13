package test1test

import AllExtentions.myLet

var age: Int? = 46

fun main() {
    val result = age?.myLet {
        if (it >=20) "you are adult"
        else "you will be adult at ${20-it} years"
    }
    result?.myLet {println(it)}


}

