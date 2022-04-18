package mumtaz.binar.chapterlima.pertemuansatu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_film.view.*
import kotlinx.android.synthetic.main.item_staf.view.*
import kotlinx.android.synthetic.main.item_user.view.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllFilmResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllStafResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllUserResponseItem

class AdapterStaf(private var datastaf : List<GetAllStafResponseItem>, private var onclick : (GetAllStafResponseItem)-> Unit): RecyclerView.Adapter<AdapterStaf.ViewHolder>() {


    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterStaf.ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_staf, parent, false)
        return  ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: AdapterStaf.ViewHolder, position: Int) {
        holder.itemView.tv_namastaff.text = datastaf[position].name
        holder.itemView.tv_email.text = datastaf[position].email
        holder.itemView.tv_create.text = datastaf[position].createdAt

        Glide.with(holder.itemView.context).load(datastaf[position].image).into(holder.itemView.img_staf)

        holder.itemView.card_status.setOnClickListener {
            onclick(datastaf[position])
        }
    }

    override fun getItemCount(): Int {
        return datastaf.size

    }

}