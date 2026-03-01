package test1test

import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val fileJ = File("testfile.json")
    val fileT = File("testfile.txt")
    println("-----st----")
    writeToFileTxt(fileT)
    println("-----1=----")
    writeToFileJson(fileJ)
    println("-----2=----")
    for (i in readFromFileT(fileT)){
        println(i)
    }
    println("-----33=----")
    for (i in readFromFileJ(fileJ)){
        println(i)
    }
    println("-----kc=----")
}

//deserialization text
fun readFromFileT(file: File): List<Item> {
    val itemsList2T = mutableListOf<Item>()
    val content = file.readText().trim()
    val itemStrings = content.split("\n")
    for (strin in itemStrings) {
        val properties = strin.split("%")
        val id = properties[0].toInt()
        val name = properties[1]
        val item = Item(id, name)
        itemsList2T.add(item)
    }
    return itemsList2T
}

//deserialization json
fun readFromFileJ(file: File): List<Item> {
    return Json.decodeFromString(file.readText().trim())
}

//serialization text
fun writeToFileTxt(file: File) {
    for (it in enterExitListItem()) {
        file.appendText("${it.id}%${it.name}\n")
    }
}

//serialization json
fun writeToFileJson(file: File) {
    file.appendText(Json.encodeToString(enterExitListItem()))
}

fun enterExitListItem(): List<Item>{
    val itemsList = mutableListOf<Item>()
    while (true) {
        println("enter id or zero to exit")
        val id = readln().toInt()
        if (id == 0) break
        println("enter name")
        val name = readln()
        val item = Item(id, name)
        itemsList += item
    }
    return itemsList
}