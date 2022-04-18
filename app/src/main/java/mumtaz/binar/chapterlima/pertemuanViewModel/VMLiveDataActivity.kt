package mumtaz.binar.chapterlima.pertemuanViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_vmlive_data.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuanViewModel.ViewModel.ViewModelDua

class VMLiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vmlive_data)

        val viewModel = ViewModelProvider(this).get(ViewModelDua::class.java)

        viewModel.addNumber.observe(this, Observer {
            tv_Numberr.text = it.toString()
        })

        viewModel.lessNumber.observe(this, Observer {
            tv_Numberr.text = it.toString()
        })

        btn_Pluss.setOnClickListener {
                viewModel.addNumber.value = viewModel.angka++
                tv_Numberr.text = viewModel.angka.toString()

        }

        btn_Minuss.setOnClickListener {

                viewModel.lessNumber.value = viewModel.angka--
                tv_Numberr.text = viewModel.angka.toString()

        }
    }
}