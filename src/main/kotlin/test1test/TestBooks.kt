package test1test
import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val flBk = File("books.json")
    adBBooks(flBk)
    readBooks(flBk)
    for (bk in readBooks(flBk)){
        println(bk)
    }
}

fun readBooks(file: File): List<Book> {
    return Json.decodeFromString<List<Book>>(file.readText().trim())
}

fun adBBooks(file: File) {
    file.appendText(Json.encodeToString(enterExitListBooks()))
}

fun enterExitListBooks(): List<Book> {
    val booksList = mutableListOf<Book>()
    while (true) {
        println("enter name or zero to exit")
        val name = readln()
        if (name == "0") break
        println("enter avtor")
        val avtor = readln()
        println("enter year of edition")
        val yearEdit = readln()
        val book = Book(name, avtor, yearEdit)
        booksList += book
    }
    return booksList
}