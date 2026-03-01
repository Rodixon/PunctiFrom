package prod1

import kotlinx.serialization.json.Json
import java.io.File

object RepoProdct {
    private val file1prdjs = File("products.json")

    private  val _products = loadProducts(file1prdjs)
        val products
            get() = _products.toList()


    fun loadProducts(file: File): List<Product> {
        return Json.decodeFromString( file.readText().trim())
    }
}