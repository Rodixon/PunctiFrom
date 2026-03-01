package prod1

data class NewProdData(
    val id: Int,
    val product_availability: Boolean,
    val product_brand: String,
    val product_category: String,
    val product_description: String,
    val product_name: String,
    val product_price: Double,
    val product_rating: Double
)