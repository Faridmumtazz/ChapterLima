package mumtaz.binar.chapterlima.pertemuansatu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_film.view.*
import kotlinx.android.synthetic.main.item_user.view.*
import mumtaz.binar.chapterlima.R
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllFilmResponseItem
import mumtaz.binar.chapterlima.pertemuansatu.model.GetAllUserResponseItem

class AdapterUser(private var datauser : List<GetAllUserResponseItem>): RecyclerView.Adapter<AdapterUser.ViewHolder>() {


    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterUser.ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return  ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: AdapterUser.ViewHolder, position: Int) {
        holder.itemView.tv_nama.text = datauser[position].name
        holder.itemView.tv_address.text = datauser[position].address
        holder.itemView.tv_umur.text = datauser[position].umur.toString()
    }

    override fun getItemCount(): Int {
        return datauser.size

    }

}