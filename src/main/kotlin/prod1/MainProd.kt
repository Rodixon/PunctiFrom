package prod1

import kotlinx.serialization.json.Json
import org.w3c.dom.ls.LSOutput
import java.io.File

fun main() {
    val products = RepoProdct.products.filterExt{it.productPrice==100.0}
    var cd1 = filter(filter(filter(products, CategProd()), PriceProd()), RatingProd())
    var cd = filter(products, PriceProd())
    cd = filter(products, object : Condition {
        override fun isSuitable(product: Product): Boolean {
            return product.productPrice > 995
        }
    })
    val prodSportLM: (Product) -> Boolean = { prod: Product -> prod.productCategory == Category.SportsSS }
    val prodSport = filterLmb(products, prodSportLM)
    val prodRat = filterLmb(products) { it.productRating > 5 }
    val prodPrice = filterLmb(products) { it.productPrice > 996 }

//    val newList1 = filterGeneric1(products){it.copy(productDescription = "Description Product")}
//    val fileDesc1 = File("productsDesc1.json")
//    val jsonString = Json.encodeToString(newList1)
//    val a1 = Json.encodeToString(newList1)
//    fileDesc1.writeText(jsonString)

    val cloth =
        filterGeneric1(filterLmb(products) { it.productCategory == Category.ClothingSS }) { it.copy(productPrice = it.productPrice * 2) }
    val clothX2Xnames = filterGeneric1(cloth) { "${it.id} ${it.productName} ${it.productPrice.toInt()} " }

    RepoProdct.products
        .filterExt { it.productPrice>100 }
        .filterExt { it.productPrice<150 }
        .filterExt { it.productCategory == Category.BeautySS }
        .transformExt { it.copy(productRating = 100.0) }
        //.transformExt { it.productName }
        .forEach{ println("${it}")}



//
//    for (prod in prdcts) {
//        println(prod)
//    }
}
fun<T, R> List<T>.transformExt( trns:(T)->R): List<R>{
    val fltr = mutableListOf<R>()
    for (a22 in  this){
        fltr.add(trns(a22))
    }
    return fltr
}

fun <R> List<Product>.filterGeneric1Ext(isSuitable: (Product) -> R): List<R> {
    val filtered = mutableListOf<R>()
    for (prod in this) {
        filtered.add(isSuitable(prod))
    }
    return filtered
}

fun List<Product>.filterLmbExt(isSuitable: (Product) -> Boolean): List<Product> {
    val filtered = mutableListOf<Product>()
    for (prod in this) {
        if (isSuitable(prod)) {
            filtered.add(prod)
        }
    }
    return filtered
}

fun List<Product>.filterExt(condition: (Product)-> Boolean): List<Product> {
    val filtered = mutableListOf<Product>()
    for (prod in this) {
        if (condition(prod)) filtered.add(prod)
    }
    return filtered
}

fun <R> filterGeneric1(products: List<Product>, isSuitable: (Product) -> R): List<R> {
    val filtered = mutableListOf<R>()
    for (prod in products) {
        filtered.add(isSuitable(prod))
    }
    return filtered
}

fun filterLmb(products: List<Product>, isSuitable: (Product) -> Boolean): List<Product> {
    val filtered = mutableListOf<Product>()
    for (prod in products) {
        if (isSuitable(prod)) {
            filtered.add(prod)
        }
    }
    return filtered
}

fun filter(products: List<Product>, condition: Condition): List<Product> {
    val filtered = mutableListOf<Product>()
    for (prod in products) {
        if (condition.isSuitable(prod)) {
            filtered.add(prod)
        }
    }
    return filtered
}







