package prod1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Category {
    @SerialName("Electronics")
    ElectronicsSS,

    @SerialName("Sports")
    SportsSS,

    @SerialName("Beauty")
    BeautySS,

    @SerialName("Clothing")
    ClothingSS,

    @SerialName("Home Goods")
    HomeGoodsSS


}