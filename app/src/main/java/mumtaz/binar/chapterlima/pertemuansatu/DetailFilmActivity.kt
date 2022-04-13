package mumtaz.binar.chapterlima.pertemuansatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_film.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllFilmResponseItem

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
    }
}