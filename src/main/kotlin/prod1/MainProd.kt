package prod1

fun main() {
    val products = RepoProdct.products

    //var cd = filter(filter(filter(products, CategProd()), PriceProd()), RatingProd())


    var cd = filter(products, PriceProd())

    cd = filter(products, object : Condition {
        override fun isSuitable(product: Product): Boolean {
            return product.productPrice > 995
        }
    })

    val prodSportLM: (Product)-> Boolean={prod:Product->prod.productCategory== Category.SportsSS}
    val prodSport = filterLmb(products, prodSportLM)

    val prodRat = filterLmb(products){it.productRating>5}
    val prodPrice = filterLmb(products){it.productPrice> 996}

    for (prod in prodRat) {
        println(prod)
    }


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







