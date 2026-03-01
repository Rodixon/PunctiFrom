package TesTTesT

import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    println("----1=======")
    val flBk = File("books.json")
    println("----2======")
    adBBooks(flBk)
    println("----33=====")
    readBooks(flBk)
    println("----44=====")
    for (bk in readBooks(flBk)){
        println(bk)
    }
    println("----=====")
}

fun readBooks(file: File): List<Book> {
    val stringsBooks = Json.decodeFromString<List<Book>>(file.readText().trim())
    return stringsBooks
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