package com.example.todo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ActivityMainBinding
import com.example.todo.databinding.ItemRecyclerViewBinding

class MyAdapter(private val datas: MutableList<String>) : RecyclerView.Adapter<MyAdapter.CustomViewHolder>() {
    // 뷰 홀더의 뷰에 데이터를 출력하려고 자동으로 호출
    inner class CustomViewHolder(private val binding: ItemRecyclerViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, position: Int) {
            binding.itemData.text = item
            binding.deleteIc.setOnClickListener { removeItem(position) }
        }
    }

    // 항목 개수를 판단하려고 자동으로 호출
    override fun getItemCount(): Int = datas.size

    // 항목의 뷰를 가지는 뷰 홀더를 준비하려고 자동으로 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(datas[position], position)
    }

    fun addItem(item: String) {
        datas.add(item)
        notifyItemInserted(datas.size - 1)
    }

    fun removeItem(position: Int) {
        if (position in datas.indices) {
            datas.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}