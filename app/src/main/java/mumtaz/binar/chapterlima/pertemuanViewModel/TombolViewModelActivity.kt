package mumtaz.binar.chapterlima.pertemuanViewModel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tombol_view_model.*
import mumtaz.binar.chapterlima.R

class TombolViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tombol_view_model)

        btn_novm.setOnClickListener {
            startActivity(Intent(this, WithoutVMActivity::class.java))
        }

        btn_vm.setOnClickListener {
            startActivity(Intent(this, UsingVMActivity::class.java))
        }

        btn_livedata.setOnClickListener {
            startActivity(Intent(this, VMLiveDataActivity::class.java))
        }
    }
}