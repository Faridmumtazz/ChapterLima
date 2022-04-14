package mumtaz.binar.chapterlima.pertemuansatu

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_film.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllFilmResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        val detailFilm = intent.getParcelableExtra<GetAllFilmResponseItem>("detailfilm")

        tv_detaljudulfilm.text = detailFilm?.name
        tv_tanggal.text = detailFilm?.date
        tv_detaldirector.text = detailFilm?.director
        tv_desc.text = detailFilm?.description

        Glide.with(this).load(detailFilm?.image).into(img_detail)

        btn_delet.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Hapus Data")
                .setMessage("Yakin Hapus Data ?")
                .setPositiveButton("Ya"){ dialogInterface : DialogInterface, i : Int ->
                    deleteDataFilm(detailFilm?.id!!.toInt())
                    finish()
                }
                .setNegativeButton("Tidak") { dialogInterface : DialogInterface, i : Int ->
                    dialogInterface.dismiss()
                }
                .show()

        }

        btn_update.setOnClickListener {
            val pindah = Intent(this, UpdateFilmActivity::class.java)
            pindah.putExtra("updatefilm", detailFilm)
            startActivity(pindah)
        }
    }

    fun deleteDataFilm(id : Int){
        ApiClient.instance.deleteFilm(id)
            .enqueue(object : Callback<Int>{
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    if (response.isSuccessful){
                        Toast.makeText(this@DetailFilmActivity, "Success", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this@DetailFilmActivity, "Failed", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
                    Toast.makeText(this@DetailFilmActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}