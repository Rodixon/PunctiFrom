package prof1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Person(
//аннотация @SerialName где в круглых скобках указывается
// название ключа по которому нужно получить это значение
    //во время сериализации и десериализации из json
    // по такому ключу нужно положить значение в эту переменную

    @SerialName("id") val id: Int,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
    @SerialName("age") val age: Int,
    @SerialName("gender") val gender: Gender,
    @SerialName("email") val email: String,
    @SerialName("address") val address: String,
    @SerialName("phone_number") val phoneNumber: String
)

