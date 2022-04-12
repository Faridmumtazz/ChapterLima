package mumtaz.binar.chapterlima.pertemuansatu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_film.view.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllFilmResponseItem

class AdapterFilm(private var datafilm : List<GetAllFilmResponseItem>): RecyclerView.Adapter<AdapterFilm.ViewHolder>() {


    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFilm.ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)
        return  ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: AdapterFilm.ViewHolder, position: Int) {
        holder.itemView.tv_judulfilm.text = datafilm[position].name
        holder.itemView.tv_tglfilm.text = datafilm[position].date
        holder.itemView.tv_sutradarafilm.text = datafilm[position].director
    }

    override fun getItemCount(): Int {
        return datafilm.size

    }

}
