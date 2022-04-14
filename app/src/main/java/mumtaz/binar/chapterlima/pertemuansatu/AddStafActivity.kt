package mumtaz.binar.chapterlima.pertemuansatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_film.*
import kotlinx.android.synthetic.main.activity_add_staf.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuansatu.model.PostStafResponse
import mumtaz.binar.chapterlima.pertemuansatu.model.RequestStaf
import mumtaz.binar.chapterlima.pertemuansatu.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddStafActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_staf)

        btn_tambahstaf.setOnClickListener {
            val name = addnamastaf.text.toString()
            val img = addimgstaf.text.toString()
            val email = addemailstaff.text.toString()
            postDataStaf(email, img, name)
            finish()
        }
    }

    fun postDataStaf(email : String, img : String, name: String){
        ApiClient.instance.postStaf(RequestStaf(email, img, name))
            .enqueue(object : Callback<List<PostStafResponse>>{
                override fun onResponse(
                    call: Call<List<PostStafResponse>>,
                    response: Response<List<PostStafResponse>>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@AddStafActivity, response.message(), Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this@AddStafActivity, response.message(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<PostStafResponse>>, t: Throwable) {
                    Toast.makeText(this@AddStafActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
    }
}