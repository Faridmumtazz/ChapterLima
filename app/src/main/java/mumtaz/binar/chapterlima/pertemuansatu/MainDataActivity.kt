package mumtaz.binar.chapterlima.pertemuansatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main_data.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuansatu.adapter.AdapterFilm
import mumtaz.binar.chapterlima.pertemuansatu.adapter.AdapterStaf
import mumtaz.binar.chapterlima.pertemuansatu.adapter.AdapterUser
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllFilmResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllStafResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllUserResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.network.ApiClient
import retrofit2.Call
import retrofit2.Response

class MainDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_data)

        getDataStaf()

        tambahdata.setOnClickListener {
            val pindah = Intent(this, AddStafActivity::class.java)
            startActivity(pindah)
        }
    }

    fun getDataFilm () {
        ApiClient.instance.getAllFilm()
            .enqueue(object : retrofit2.Callback<List<GetAllFilmResponseItem>>{

                override fun onResponse(
                    call: Call<List<GetAllFilmResponseItem>>,
                    response: Response<List<GetAllFilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                        val dataFilm = response.body()
                        val adapterFilm = AdapterFilm(dataFilm!!){
                            val pindah = Intent(this@MainDataActivity, DetailFilmActivity::class.java)
                            pindah.putExtra("detailfilm", it)
                            startActivity(pindah)
                        }
                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                        rv_film.layoutManager = lm
                        rv_film.adapter = adapterFilm
                    }else {
                        Toast.makeText(this@MainDataActivity, response.message(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainDataActivity, t.message, Toast.LENGTH_LONG).show()
                }


            })
    }

    fun getDataUser () {
        ApiClient.instance.getAllUser()
            .enqueue(object : retrofit2.Callback<List<GetAllUserResponseItem>>{

                override fun onResponse(
                    call: Call<List<GetAllUserResponseItem>>,
                    response: Response<List<GetAllUserResponseItem>>
                ) {
                    if (response.isSuccessful){
                        val dataUser = response.body()
                        val adapterUser = AdapterUser(dataUser!!)
                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                        rv_film.layoutManager = lm
                        rv_film.adapter = adapterUser
                    }else {
                        Toast.makeText(this@MainDataActivity, response.message(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllUserResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainDataActivity, t.message, Toast.LENGTH_LONG).show()
                }


            })
    }

    fun getDataStaf () {
        ApiClient.instance.getAllStaf()
            .enqueue(object : retrofit2.Callback<List<GetAllStafResponseItem>>{

                override fun onResponse(
                    call: Call<List<GetAllStafResponseItem>>,
                    response: Response<List<GetAllStafResponseItem>>
                ) {
                    if (response.isSuccessful){
                        val dataStaf = response.body()
                        val adapterStaf = AdapterStaf(dataStaf!!){
                            val pindah = Intent(this@MainDataActivity, DetailStafActivity::class.java)
                            pindah.putExtra("detailstaf", it)
                            startActivity(pindah)
                        }
                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                        rv_film.layoutManager = lm
                        rv_film.adapter = adapterStaf
                    }else {
                        Toast.makeText(this@MainDataActivity, response.message(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllStafResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainDataActivity, t.message, Toast.LENGTH_LONG).show()
                }


            })
    }

    override fun onResume() {
        super.onResume()
        getDataStaf()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}