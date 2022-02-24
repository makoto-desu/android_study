package com.example.makotosampleapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.bumptech.glide.Glide


class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.detail_fragment, container, false)

        activity?.title = "詳細情報"

        // 一覧画面から渡されたデータをviewに表示する
        setFragmentResultListener("data") { _, bundle ->
            val image: ImageView = view.findViewById(R.id.image)
            Glide.with(view).load(bundle.getString("image")).into(image)
            val title: TextView = view.findViewById(R.id.title)
            title.text = bundle.getString("title")
            val desc: TextView = view.findViewById(R.id.desc)
            desc.text = bundle.getString("desc")
        }

        return view
    }
}
