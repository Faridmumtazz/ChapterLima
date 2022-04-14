package mumtaz.binar.chapterlima.pertemuansatu.network

import mumtaz.binar.chapterlima.pertemuansatu.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

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
}