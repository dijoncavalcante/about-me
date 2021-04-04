package com.dijon.aboutme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AboutViewPagerAdapter(private var ask: List<String>, private var answer: List<String>) :
    RecyclerView.Adapter<AboutViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_ask = itemView.findViewById<TextView>(R.id.tv_askAboutMe)
        val tv_answer = itemView.findViewById<TextView>(R.id.tv_answerAboutMe)

        init {
            tv_answer.setOnClickListener { v: View ->
                val position = adapterPosition
                Toast.makeText(
                    itemView.context,
                    "You clicked on item #${position + 1}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AboutViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_page_about_me, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return ask.size
    }

    override fun onBindViewHolder(holder: AboutViewPagerAdapter.Pager2ViewHolder, position: Int) {

        holder.tv_ask.text = ask[position]
        holder.tv_answer.text = answer[position]

    }

}