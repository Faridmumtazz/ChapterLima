package mumtaz.binar.chapterlima.pertemuanViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_using_vmactivity.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuanViewModel.ViewModel.ViewModelSatu

class UsingVMActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_using_vmactivity)

        var viewModel = ViewModelProvider(this).get(ViewModelSatu::class.java)

        tv_Number.text = viewModel.angka.toString()

        btn_Plus.setOnClickListener {
            viewModel.angka++
            tv_Number.text = viewModel.angka.toString()
        }

        btn_Minus.setOnClickListener {
            viewModel.angka--
            tv_Number.text = viewModel.angka.toString()
        }
    }
}