package com.example.natifetask.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.natifetask.data.GifDTO
import com.example.natifetask.databinding.ItemGifBinding

class MainFragmentAdapter(
    private val onClickProductListener: (GifDTO) -> Unit,

    ) :
    ListAdapter<GifDTO, MainFragmentAdapter.GifViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holderShop: GifViewHolder, position: Int) {
        holderShop.bind(currentList[position], onClickProductListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        return GifViewHolder(
            ItemGifBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class GifViewHolder(private var binding: ItemGifBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gif: GifDTO, onClickProductListener: (GifDTO) -> Unit) {
            Log.d("tagggg", "${gif.url}")
            binding.apply {
                Glide.with(itemView.context).load(gif.images.original.url).into(imageView)
                name.text = gif.username
                itemView.setOnClickListener {
                    onClickProductListener.invoke(gif)
                }
            }

        }
    }

    class DiffCallback : DiffUtil.ItemCallback<GifDTO>() {

        override fun areItemsTheSame(oldItem: GifDTO, newItem: GifDTO): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GifDTO, newItem: GifDTO): Boolean {
            return oldItem == newItem
        }
    }

}