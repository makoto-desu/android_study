package com.example.makotosampleapp

import Sample
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val sampleList: ArrayList<Sample>)
    : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // Viewの初期化
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val desc: TextView
        val image: ImageView

        init {
            title = view.findViewById(R.id.title)
            desc = view.findViewById(R.id.desc)
            image = view.findViewById(R.id.image)
        }
    }

    // レイアウトの設定
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(view)
    }

    // Viewの設定
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val sampleData = sampleList[position]

        viewHolder.title.text = sampleData.title
        viewHolder.desc.text = sampleData.desc
        viewHolder.image.setImageResource(sampleData.imageId)
    }

    // 表示数を返す
    override fun getItemCount() = sampleList.size
}