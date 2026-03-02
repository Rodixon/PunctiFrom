package test2

// TODO: Определить функцию высшего порядка processNumbers
// 1. Функция должна принимать:
//    - Список чисел для обработки.
//    - Лямбда-выражение для фильтрации чисел (возвращает Boolean).
//    - Лямбда-выражение для преобразования чисел (возвращает Int).
// 2. Реализовать логику фильтрации чисел на основе переданного лямбда-выражения.
// 3. Преобразовать отфильтрованные числа с помощью второго лямбда-выражения.
// 4. Вернуть новый список с преобразованными числами.
// TODO: Определить функцию startProcessing
// 1. Вывести сообщение: "Введите числа, разделенные пробелами:".
// 2. Считать строку чисел, введённую пользователем.
// 3. Преобразовать строку в список чисел.
// 4. Вызвать функцию processNumbers с:
//    - Условием: числа больше 10.
//    - Преобразованием: умножение числа на 3.
// 5. Вывести результат обработки в формате: .
fun processNumbers(
    aaInts: List<Int>,
    isSuitable: (aInt1: Int) -> Boolean,
    transf: (aInt2: Int) -> Int
): List<Int> {
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    for (a in aaInts) {
        if (isSuitable(a)) {
            list1.add(a)
        }
    }

    for (a in list1) {
        val b = transf(a)
        list2.add(b)

    }

    val aa = aaInts
        .filter { isSuitable(it) }
        .map { transf(it) }
    return aa
}

fun startProcessing() {
    //println("---0----")
    println("Введите числа, разделенные пробелами:")
    //println("---8---")

    println(
        "Результат обработки: ${
            processNumbers(
                readln()
                    .trim()
                    .split(" ")
                    .map { it.toInt() },
                { it > 10 },
                { it * 3 },
            )
        }"
    )
}

val strings = listOf("1", "2", "3") // Коллекция строк
val numbers = strings.map { it.toInt() } // Преобразование строк в числа

//println(numbers) // [1, 2, 3]
fun main() {
    println("push3")
}