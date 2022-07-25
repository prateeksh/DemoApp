package company.project.demoapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import company.project.demoapp.R
import company.project.demoapp.ui.model.Coins
import company.project.demoapp.ui.model.List

class CoinsAdapter (private val coinsList: Coins): RecyclerView.Adapter<CoinsAdapter.CoinsViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsViewHolder {

        val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.card_view_design, parent, false)
        Log.e("CoinsAdapter ", "adapter called: " )
        return CoinsViewHolder(view)

    }

    override fun onBindViewHolder(holder: CoinsViewHolder, position: Int) {

        val ItemsViewModel = coinsList
        val dataList: ArrayList<List>

        dataList = ItemsViewModel.data.list

        // sets the image to the imageview from our itemHolder class\
        val name = dataList.get(position).name;
        val history = dataList.get(position).history
        val image = dataList.get(position).pictures?.front?.url


        if (image != null){

            Glide
                .with(holder.itemView.context)
                .load(image)
                .into(holder.image)
        }

        holder.history.text = history
        holder.name.text = name


    }

    override fun getItemCount(): Int {

        return coinsList.data.list.size
    }

    class CoinsViewHolder (ItemView: View) : RecyclerView.ViewHolder(ItemView){

        val name: TextView = itemView.findViewById(R.id.name)
        val history: TextView = itemView.findViewById(R.id.history)
        val image: ImageView = itemView.findViewById(R.id.coin_image)
    }

}