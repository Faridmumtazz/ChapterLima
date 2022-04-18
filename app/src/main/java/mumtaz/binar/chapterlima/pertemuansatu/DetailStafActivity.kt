package mumtaz.binar.chapterlima.pertemuansatu

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_film.*
import kotlinx.android.synthetic.main.activity_detail_staf.*
import kotlinx.android.synthetic.main.item_staf.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllFilmResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllStafResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailStafActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_staf)

        val detailstaf = intent.getParcelableExtra<GetAllStafResponseItem>("detailstaf")

        tv_detalnamastaf.text = detailstaf?.name
        tv_tanggalstaf.text = detailstaf?.createdAt
        tv_detalemailstaf.text = detailstaf?.email

//        Glide.with(this).load(detailstaf?.image).into(img_staf)

        btn_deletestaf.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Hapus Data")
                .setMessage("Yakin Hapus Data ?")
                .setPositiveButton("Ya"){ dialogInterface : DialogInterface, i : Int ->
                    deleteDataStaf(detailstaf?.id!!.toInt())
                    finish()
                }
                .setNegativeButton("Tidak") { dialogInterface : DialogInterface, i : Int ->
                    dialogInterface.dismiss()
                }
                .show()

        }

        btn_updatestaf.setOnClickListener {
            val pindah = Intent(this, UpdateStafActivity::class.java)
            pindah.putExtra("updatestaf", detailstaf)
            startActivity(pindah)
        }
    }

    fun deleteDataStaf(id : Int){
        ApiClient.instance.deleteStaf(id)
            .enqueue(object : Callback<Int> {
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    if (response.isSuccessful){
                        Toast.makeText(this@DetailStafActivity, "Success", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this@DetailStafActivity, "Failed", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
                    Toast.makeText(this@DetailStafActivity, t.message, Toast.LENGTH_LONG).show()
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