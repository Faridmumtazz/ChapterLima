package mumtaz.binar.chapterlima.pertemuansatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_film.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuansatu.model.PostFIlmResponse
import mumtaz.binar.chapterlima.pertemuansatu.model.RequestFilm
import mumtaz.binar.chapterlima.pertemuansatu.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_film)

        btn_tambah.setOnClickListener {
            val name = addnamafilm.text.toString()
            val img = addimgfilm.text.toString()
            val direct = addnamadirector.text.toString()
            val desc = adddescfilm.text.toString()
            postDataFilm(desc, direct, img, name)
            finish()
        }
    }

    fun postDataFilm(desc : String, direct: String, img:String, name: String){
        ApiClient.instance.postFilm(RequestFilm(desc,direct,img,name))
            .enqueue(object : Callback<List<PostFIlmResponse>>{

                override fun onResponse(
                    call: Call<List<PostFIlmResponse>>,
                    response: Response<List<PostFIlmResponse>>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@AddFilmActivity, response.message(), Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this@AddFilmActivity, response.message(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<PostFIlmResponse>>, t: Throwable) {
                    Toast.makeText(this@AddFilmActivity, t.message, Toast.LENGTH_LONG).show()
                }


            })
    }


}