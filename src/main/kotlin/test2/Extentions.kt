package test2

fun main() {
    val a1 = readln().toInt()
    println(a1.isPlus())



}


fun Int.isPlus() = this > 0

fun List<Int>.sumOfEvens(): Int = this.filter { it % 2 == 0 }.sum()


fun processList() {
    println("Сумма чётных чисел: ${readln()
        .trim()
        .split(" ")
        .map { it.toInt() }.sumOfEvens()}")
}

fun primer(){
    println("primer")
}


// TODO: Напишите extension-функцию для класса List<Int>
// 1. Назовите её sumOfEvens.
// 2. Подсчитайте сумму всех чётных чисел в списке.

// TODO: Напишите функцию processList
// 1. Считайте строку чисел, введённую пользователем.
// 2. Преобразуйте строку в список целых чисел.
// 3. Вызовите extension-функцию sumOfEvens для списка.
// 4. Выведите результат вычисления.

