package mumtaz.binar.chapterlima.pertemuansatu.network

import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllFilmResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllStafResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllUserResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("film")
    fun getAllFilm() : Call<List<GetAllFilmResponseItem>>

    @GET("user")
    fun getAllUser() : Call<List<GetAllUserResponseItem>>

    @GET("staf")
    fun getAllStaf() : Call<List<GetAllStafResponseItem>>
}