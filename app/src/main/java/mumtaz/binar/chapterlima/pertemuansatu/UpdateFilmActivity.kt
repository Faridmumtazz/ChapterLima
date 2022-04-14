package mumtaz.binar.chapterlima.pertemuansatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_film.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllFilmResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.model.RequestFilm
import mumtaz.binar.chapterlima.pertemuansatu.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_film)

        val getFilm = intent.getParcelableExtra<GetAllFilmResponseItem>("updatefilm")

        updnamafilm.setText(getFilm?.name)
        updnamadirector.setText(getFilm?.director)
        updimgfilm.setText(getFilm?.image)
        upddescfilm.setText(getFilm?.description)

        btn_updatedd.setOnClickListener {
            val id = getFilm?.id
            val name = updnamafilm.text.toString()
            val img = updimgfilm.text.toString()
            val direc = updnamadirector.text.toString()
            val desc = upddescfilm.text.toString()
            updateDataFilm(id!!.toInt(), desc, direc, img, name)
            finish()
        }
    }

    fun updateDataFilm(id: Int, name : String, img:String, desc:String, direc: String){
        ApiClient.instance.updateFilm(id, RequestFilm(desc, direc,img, name))
            .enqueue(object : Callback<List<GetAllFilmResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllFilmResponseItem>>,
                    response: Response<List<GetAllFilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@UpdateFilmActivity, "Success", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this@UpdateFilmActivity, "Failed", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
                    Toast.makeText(this@UpdateFilmActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
    }
}