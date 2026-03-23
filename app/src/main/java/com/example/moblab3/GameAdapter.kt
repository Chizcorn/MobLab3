package com.MobLab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(
    private val tips: List<GameTip>,
    private val onItemClick: (GameTip) -> Unit
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textDay: TextView = view.findViewById(R.id.text_day)
        val textTitle: TextView = view.findViewById(R.id.text_title)
        val textDescription: TextView = view.findViewById(R.id.text_description)
        val imageTip: ImageView = view.findViewById(R.id.image_tip)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_game_tip, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val tip = tips[position]
        val context = holder.itemView.context

        holder.textDay.text = context.getString(R.string.day_format, tip.dayNumber)
        holder.textTitle.text = tip.title
        holder.textDescription.text = tip.description

        if (tip.imageResId != 0) {
            holder.imageTip.setImageResource(tip.imageResId)
        } else {
            holder.imageTip.setImageResource(android.R.drawable.ic_menu_gallery)
        }

        holder.itemView.setOnClickListener {
            onItemClick(tip)
        }
    }

    override fun getItemCount(): Int = tips.size
}