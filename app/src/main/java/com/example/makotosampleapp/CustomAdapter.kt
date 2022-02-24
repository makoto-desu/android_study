package com.example.makotosampleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(private val noticeList: NoticeList?)
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
        val noticeData = noticeList!!.data[position]

        viewHolder.title.text = noticeData.title
        viewHolder.desc.text = noticeData.description
//        viewHolder.image.setImageURI(Uri.parse(noticeData.imageUrl))
        Glide.with(viewHolder.itemView).load(noticeData.image).into(viewHolder.image)

        viewHolder.itemView.setOnClickListener {
            listener.onItemClick(noticeData)
        }
    }

    override fun getItemCount() = if (noticeList == null) 0 else noticeList.data.size

    // リスナを格納する変数を定義（lateinitで初期化を遅らせている）
    private lateinit var listener: OnCellClickListener

    // インターフェースを作成
    interface  OnCellClickListener {
        fun onItemClick(notice: Notice)
    }

    // リスナーをセット
    fun setOnCellClickListener(listener: OnCellClickListener) {
        this.listener = listener
    }
}
