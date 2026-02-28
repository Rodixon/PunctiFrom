package TesTTesT

import java.io.File

fun main() {
    val file = File("testfile.txt")
    //writeToFile(file)
    for (i in readFromFile(file)){
        println(i)
    }

}
//deserialization
fun readFromFile(file: File): List<Item> {
    val itemsList2 = mutableListOf<Item>()
    val content = file.readText().trim()
    val itemStrings = content.split("\n")
    for (strin in itemStrings) {
        val properties = strin.split("%")
        val id = properties[0].toInt()
        val name = properties[1]
        val item = Item(id, name)
        itemsList2.add(item)
    }
    return itemsList2

}
//serialization
fun writeToFile(file: File) {
    val itemsList = mutableListOf<Item>()
    while (true) {
        println("enter id or zero to exirt")
        val id = readln().toInt()
        if (id == 0) break
        println("enter name")
        val name = readln()
        val item = Item(id, name)
        itemsList += item
    }
    for (it in itemsList) {
        file.appendText("${it.id}%${it.name}\n")
    }
}