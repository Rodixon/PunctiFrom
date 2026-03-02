package prod1

class CategProd: Condition {
    override fun isSuitable(product: Product): Boolean {
        return product.productCategory == Category.ClothingSS
    }
}