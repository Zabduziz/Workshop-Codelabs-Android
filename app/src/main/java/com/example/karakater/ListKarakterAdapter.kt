package com.example.karakater

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.karakater.databinding.ItemRowKarakterBinding

class ListKarakterAdapter(private val list : ArrayList<Karakters>) :
    RecyclerView.Adapter<ListKarakterAdapter.ListViewHolder>() {
    inner class ListViewHolder (private val binding : ItemRowKarakterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(karakters : Karakters){
            with(binding){
                tvKarakterName.text = karakters.name
                tvDetailKarakter.text = karakters.detail
                Glide.with(itemView.context)
                    .load(karakters.photo)
                    .apply(RequestOptions().override(260, 260))
                    .into(ivKarakter)
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DETAIL, karakters)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowKarakterBinding.inflate((LayoutInflater.from(parent.context)), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]

        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}