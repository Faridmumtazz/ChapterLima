package mumtaz.binar.chapterlima.pertemuansatu.network

import androidx.room.Update
import mumtaz.binar.chapterlima.pertemuansatu.model.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("film")
    fun getAllFilm() : Call<List<GetAllFilmResponseItem>>

    @GET("user")
    fun getAllUser() : Call<List<GetAllUserResponseItem>>

    @GET("staf")
    fun getAllStaf() : Call<List<GetAllStafResponseItem>>

    @POST("film")
    fun postFilm(@Body req : RequestFilm) : Call<List<PostFIlmResponse>>

    @POST("staf")
    fun postStaf(@Body request : RequestStaf) : Call<List<PostStafResponse>>

    @DELETE("film/{id}")
    fun deleteFilm(@Path("id") id : Int) : Call<Int>

    @PUT("film/{id}")
    fun updateFilm(
        @Path("id") id : Int,
        @Body reques : RequestFilm
    )
    :Call<List<GetAllFilmResponseItem>>

    @DELETE("staf/{id}")
    fun deleteStaf(@Path("id") id: Int) : Call<Int>

    @PUT("staf/{id}")
    fun updateStaf(
        @Path("id") id : Int,
        @Body request : RequestStaf
    )
    :Call<List<GetAllStafResponseItem>>
}