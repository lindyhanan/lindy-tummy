package com.example.lindy_tummy.About

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lindy_tummy.databinding.ItemInfoBinding

class InfoAdapter(
    private val infoList: List<InfoModel>,
    private val onItemClick: (InfoModel) -> Unit
) : RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {

    inner class InfoViewHolder(
        val binding: ItemInfoBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InfoViewHolder {

        val binding = ItemInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return InfoViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: InfoViewHolder,
        position: Int
    ) {

        val item = infoList[position]

        with(holder.binding) {

            tvInfoName.text = item.title
            tvInfoDescription.text = item.description

            Glide.with(holder.itemView.context)
                .load(item.imageUrl)
                .into(imgInfo)

            root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun getItemCount(): Int = infoList.size
}