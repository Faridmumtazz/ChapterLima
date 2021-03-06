package mumtaz.binar.chapterlima.pertemuansatu.model


import com.google.gson.annotations.SerializedName

data class GetAllUserResponseItem(
    @SerializedName("address")
    val address: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("umur")
    val umur: Int
)