package com.kis.mkb_test.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kis.mkb_test.databinding.AssetsRowBinding
import com.kis.mkb_test.model.pojo.AssetRate

class AssetsAdapter(var assets : List<AssetRate>) : RecyclerView.Adapter<AssetsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AssetsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(assets[position])
    }

    override fun getItemCount(): Int = assets.size

    class ViewHolder(private val binding: AssetsRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(rate : AssetRate) {
            binding.assetsRowCurMnemTo.text = rate.currMnemTo
            binding.assetsRowCurCodeTo.text = String.format("(%d)", rate.to)
            binding.assetsRowBuyForValue.text = rate.buy.toString()
            binding.assetsRowBuyDelta.text = rate.deltaBuy.toString()
            binding.assetsRowSellForValue.text = rate.sale.toString()
            binding.assetsRowSellDelta.text = rate.deltaSale.toString()
            binding.assetsRowCurMnemFrom.text = rate.currMnemFrom
            binding.assetsRowCurCodeFrom.text = String.format("(%d)", rate.from)
        }
    }
}

