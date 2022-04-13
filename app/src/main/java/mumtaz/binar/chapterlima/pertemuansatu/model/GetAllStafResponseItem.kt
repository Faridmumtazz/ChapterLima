package mumtaz.binar.chapterlima.pertemuansatu.model


import com.google.gson.annotations.SerializedName

data class GetAllStafResponseItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)