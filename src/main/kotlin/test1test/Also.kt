package test1test

fun main() {

}


/**
 * Обрабатывает коллекцию строк с использованием цепочки преобразований.
 * @param strings Коллекция строк для обработки.
 * @return Преобразованная коллекция строк.
 */
fun processStrings(strings: List<String>): List<String> {
    return strings.also { println("Исходный список: [${it.joinToString(", ")}]") }
        .filter { it.isNotBlank() }
        .also { println("Этап 1: Осталось ${strings.count()} непустых строк") }
        // Убираем пустые строки

        .map { it.trim() }
        // Убираем лишние пробелы

        .filter { it.length > 3 }
        .also { println("Этап 2: Строки длиной более 3 символов: ${it.filter { it.length > 3 }}") }
        // Оставляем строки длиной больше 3

        .sortedBy { it.length }
        .also { println("Этап 3: Первые 3 строки после сортировки: [${it.take(3).joinToString(", ")}]") }
        // Сортируем по длине

        .map { it.uppercase() }
        .also{ println("Этап 4: Все строки в верхнем регистре: [${it.joinToString(", ")}]")}
        // Преобразуем в верхний регистр

        .distinct()
        // Убираем дубликаты
        .take(5)
        .also{ println("Этап 5: Итоговый результат: [${it.joinToString(", ")}]")}
// Берём первые 5 строк
}