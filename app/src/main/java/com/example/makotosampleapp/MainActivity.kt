package com.example.makotosampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setTitle("TEST LIST");

        // BookListFragment表示処理
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_activity_main, ListFragment())
            .commit()
    }
}