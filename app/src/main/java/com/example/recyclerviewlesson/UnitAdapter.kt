package com.example.recyclerviewlesson

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlesson.databinding.UnitItemBinding
import kotlin.collections.ArrayList

class UnitAdapter : RecyclerView.Adapter<UnitAdapter.UnitHolder>() {
    var unitList = ArrayList<Unit>()

    class UnitHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = UnitItemBinding.bind(item)

        fun bind(unit: Unit) = with(binding) {
            image.setImageResource(unit.imageId)
            tvTitle.text = unit.title
            tvTitle.textSize = 30f
            tvTitle.setTextColor(Color.WHITE)
            linLayout.setBackgroundResource(unit.bg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.unit_item, parent, false)
        return UnitHolder(view)
    }

    override fun onBindViewHolder(holder: UnitHolder, position: Int) {
        holder.bind(unitList[position])
    }

    override fun getItemCount(): Int = unitList.size

    fun addUnit(unit: Unit){
        unitList.add(unit)
        notifyDataSetChanged()
    }
}
