package prod1

fun main() {
        val products = RepoProdct.products

        //var cd = filter(filter(filter(products, CategProd()), PriceProd()), RatingProd())


        var cd = filter(products, PriceProd())

        cd = filter(products, object : Condition {
                override fun isSuitable(product: Product): Boolean {
                        return  product.productPrice>995
                }
        })
        for (prod in cd) {
                println(prod)
        }


}

fun filter(products: List<Product>, condition: Condition): List<Product> {
        val filtered = mutableListOf<Product>()
        for (prod in products) {
                if(condition.isSuitable(prod)) {
                      filtered.add(prod)
                }
        }
        return filtered
}







