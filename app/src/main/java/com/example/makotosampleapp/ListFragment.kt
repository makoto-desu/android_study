package com.example.makotosampleapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var mAdapter: CustomAdapter

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.list_fragment, container, false)

        activity?.title = "一覧"
        getNoticeList()

        return view
    }

    fun getNoticeList() {
        RetrofitClient.service.getNoticeList().enqueue(object : Callback<NoticeList> {
            override fun onResponse(
                call: Call<NoticeList>,
                response: Response<NoticeList>
            ) {
                if (response.isSuccessful) {
                    Log.i("Info", response.body().toString())
                    var result: NoticeList? = response!!.body()
                    if (result != null) {
                        setRecyclerView(result)
                    }
                }
            }

            override fun onFailure(call: Call<NoticeList>, t: Throwable) {
                Log.e("Error", t.toString())
            }
        })
    }

    fun setRecyclerView(data: NoticeList?) {
        // RecyclerViewの取得
        var recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)

        // LayoutManagerの設定
        recyclerView?.layoutManager = LinearLayoutManager(view?.context)

        // CustomAdapterの生成と設定
        mAdapter = CustomAdapter(data)
//        mAdapter.notifyDataSetChanged()
        recyclerView?.adapter = mAdapter

        mAdapter.setOnCellClickListener(
            // インターフェースの再利用は想定しておらず、その場限りでしか使わないためobject式として宣言
            object : CustomAdapter.OnCellClickListener {
                override fun onItemClick(notice: Notice) {

                    setFragmentResult("data", bundleOf(
                        "image" to notice.image,
                        "title" to notice.title,
                        "desc" to notice.description
                    ))

                    // 画面遷移処理
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_activity_main, DetailFragment())
                        .addToBackStack(null)
                        .commit()
                }
            }
        )
    }

}
