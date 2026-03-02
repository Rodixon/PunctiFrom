package prod1

class RatingProd: Condition{
    override fun isSuitable(product: Product): Boolean {
        return product.productRating>1
    }
}