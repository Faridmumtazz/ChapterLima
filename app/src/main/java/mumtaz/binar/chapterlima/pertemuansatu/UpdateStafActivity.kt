package mumtaz.binar.chapterlima.pertemuansatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_staf.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllFilmResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllStafResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.model.RequestFilm
import mumtaz.binar.chapterlima.pertemuansatu.model.RequestStaf
import mumtaz.binar.chapterlima.pertemuansatu.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateStafActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_staf)

        val getStaf = intent.getParcelableExtra<GetAllStafResponseItem>("updatestaf")

        updnamastaf.setText(getStaf?.name)
        updemail.setText(getStaf?.email)
        updimgstaf.setText(getStaf?.image)

        btn_updated.setOnClickListener {
            val id = getStaf?.id
            val name = updnamastaf.text.toString()
            val email = updemail.text.toString()
            val img = updimgstaf.text.toString()
            updateDataStaf(id!!.toInt(), email, img, name)
            finish()
        }
    }

    fun updateDataStaf (id : Int, name: String, email: String, img: String ){
        ApiClient.instance.updateStaf(id, RequestStaf(email,img, name))
            .enqueue(object : Callback<List<GetAllStafResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllStafResponseItem>>,
                    response: Response<List<GetAllStafResponseItem>>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@UpdateStafActivity, "Success", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this@UpdateStafActivity, "Failed", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllStafResponseItem>>, t: Throwable) {
                    Toast.makeText(this@UpdateStafActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
    }
}