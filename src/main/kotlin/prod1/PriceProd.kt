package prod1

import prof1.Person

class PriceProd: Condition {
    override fun isSuitable(product: Product): Boolean {
        return product.productPrice<10
    }
}