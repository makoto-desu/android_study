package com.example.makotosampleapp

import Sample
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


lateinit var mAdapter: CustomAdapter
lateinit var mSampleList: ArrayList<Sample>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("TEST LIST");

        val data1 = Sample("たいとるだよ！", "説明！", R.drawable.sample1)
        val data2 = Sample("たいとるですよ！", "説明！", R.drawable.sample1)
        val data3 = Sample("たいとるだわよ！！", "説明！", R.drawable.sample1)
        val data4 = Sample("たいとるん", "説明！", R.drawable.sample1)
        val data5 = Sample("TITILEEEE", "説明！", R.drawable.sample1)
        val data6 = Sample("たいとるだよ！", "説明！", R.drawable.sample1)
        val data7 = Sample("たいとるですよ！", "説明！", R.drawable.sample1)
        val data8 = Sample("たいとるだわよ！！", "説明！", R.drawable.sample1)
        val data9 = Sample("たいとるん", "説明！", R.drawable.sample1)
        val data10 = Sample("TITILEEEE", "説明！", R.drawable.sample1)
        val data11 = Sample("たいとるだよ！", "説明！", R.drawable.sample1)
        val data12 = Sample("たいとるですよ！", "説明！", R.drawable.sample1)
        val data13 = Sample("たいとるだわよ！！", "説明！", R.drawable.sample1)
        val data14 = Sample("たいとるん", "説明！", R.drawable.sample1)
        val data15 = Sample("TITILEEEE", "説明！", R.drawable.sample1)
        val data16 = Sample("たいとるだよ！", "説明！", R.drawable.sample1)
        val data17 = Sample("たいとるですよ！", "説明！", R.drawable.sample1)
        val data18 = Sample("たいとるだわよ！！", "説明！説明！説明！説明！説明！説明！説明！説明！説明！説明！説明！説明！説明！説明！説明！説明！", R.drawable.sample1)
        val data19 = Sample("たいとるん", "説明！", R.drawable.sample1)
        val data20 = Sample("TITILEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE", "説明！", R.drawable.sample1)
        val data21 = Sample("たいとるだよ！", "説明！", R.drawable.sample1)
        val data22 = Sample("たいとるですよ！", "説明！", R.drawable.sample1)
        val data23 = Sample("たいとるだわよ！！", "説明！", R.drawable.sample1)
        val data24 = Sample("たいとるん", "説明！", R.drawable.sample1)
        val data25 = Sample("TITILEEEE123", "説明！", R.drawable.sample1)
        mSampleList = arrayListOf(
            data1,
            data2,
            data3,
            data4,
            data5,
            data6,
            data7,
            data8,
            data9,
            data10,
            data11,
            data12,
            data13,
            data14,
            data15,
            data16,
            data17,
            data18,
            data19,
            data20,
            data21,
            data22,
            data23,
            data24,
            data25
        )

        // RecyclerViewの取得
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        // LayoutManagerの設定
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 境界線
//        val dividerItemDecoration = DividerItemDecoration(
//            this, LinearLayoutManager(this).getOrientation()
//        )
//        recyclerView.addItemDecoration(dividerItemDecoration)

        // CustomAdapterの生成と設定
        mAdapter = CustomAdapter(mSampleList)
        recyclerView.adapter = mAdapter

//        // Fragment表示処理
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.fl_activity_main, TestListFragment())
//            .commit()
    }
}