package com.kis.mkb_test.ui.assets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kis.mkb_test.databinding.AssetsRowBinding
import com.kis.mkb_test.model.pojo.AssetRate

class AssetsAdapter(var assets : List<AssetRate>, val listener: ((Int)-> Unit)? = null) : RecyclerView.Adapter<AssetsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AssetsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(assets[position])
    }

    override fun getItemCount(): Int = assets.size

    inner class ViewHolder(private val binding: AssetsRowBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.assetsRowCard.setOnClickListener {
                listener?.let {
                    listener.invoke(adapterPosition)
                }
            }
        }
        fun bind(rate : AssetRate) {
            with (rate) {
                binding.assetsRowCurMnemTo.text = currMnemTo
                binding.assetsRowCurCodeTo.text = String.format("(%d)", to)
                binding.assetsRowBuyForValue.text = buy.toString()
                binding.assetsRowBuyDelta.text = deltaBuy.toString()
                binding.assetsRowSellForValue.text = sale.toString()
                binding.assetsRowSellDelta.text = deltaSale.toString()
                binding.assetsRowCurMnemFrom.text = currMnemFrom
                binding.assetsRowCurCodeFrom.text = String.format("(%d)", from)
            }
        }
    }

}

