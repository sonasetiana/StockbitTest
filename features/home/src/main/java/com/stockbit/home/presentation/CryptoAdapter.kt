package com.stockbit.home.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stockbit.home.databinding.ItemCryptoBinding
import com.stockbit.model.entity.crypto.Watchlist

class CryptoAdapter : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    private val items: ArrayList<Watchlist> = arrayListOf()

    fun addItems(items: List<Watchlist>) {
        this.items.addAll(items)
        notifyItemRangeInserted(itemCount - items.size, items.size)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCryptoBinding.inflate(inflater)
        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.binding.data = items[position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CryptoViewHolder(
        val binding: ItemCryptoBinding
    ) : RecyclerView.ViewHolder(binding.root)
}