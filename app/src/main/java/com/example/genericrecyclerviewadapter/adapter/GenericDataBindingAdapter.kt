package com.example.genericrecyclerviewadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding

class GenericDataBindingAdapter<T, VH : ViewBinding>(
    private val inflater: (LayoutInflater, ViewGroup, Boolean) -> VH,
    private val bindToView: (VH,T) -> Unit
) : Adapter<GenericDataBindingAdapter<T, VH>.GenericDataBindingViewHolder>() {

    private var data = ArrayList<T>()

    inner class GenericDataBindingViewHolder(private val binding: VH) : ViewHolder(binding.root) {
        fun bind(itemData: T) {
            bindToView(binding,itemData)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericDataBindingViewHolder {
        val binding = inflater(LayoutInflater.from(parent.context), parent, false)
        return GenericDataBindingViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: GenericDataBindingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun setData(newData: ArrayList<T>) {
        val genericDataBindingDiffUtil = GenericDataBindingDiffUtil(data, newData)
        val genericDataBindingDiff = DiffUtil.calculateDiff(genericDataBindingDiffUtil)
        data = newData
        genericDataBindingDiff.dispatchUpdatesTo(this)
    }

    inner class GenericDataBindingDiffUtil(
        private val oldData: ArrayList<T>,
        private val newData: ArrayList<T>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldData.size

        override fun getNewListSize() = newData.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldData[oldItemPosition] == newData[newItemPosition]

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldData[oldItemPosition].toString().contentEquals(newData[newItemPosition].toString())
    }
}