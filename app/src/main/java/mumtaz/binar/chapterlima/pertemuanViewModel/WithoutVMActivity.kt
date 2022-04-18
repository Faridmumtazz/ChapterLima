package mumtaz.binar.chapterlima.pertemuanViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_without_vmactivity.*
import mumtaz.binar.chapterlima.R

class WithoutVMActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_without_vmactivity)

        var angka = 0

        btnPlus.setOnClickListener {
            angka++
            tvNumber.text = angka.toString()
        }
        btnMinus.setOnClickListener {
            angka--
            tvNumber.text = angka.toString()
        }
    }
}