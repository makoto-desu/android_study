package com.example.makotosampleapp

import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    public var service: ApiService

    init {
        val gsonFactory = GsonConverterFactory.create(GsonBuilder().serializeNulls().create())

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(gsonFactory)
            .build()

        service = retrofit.create(ApiService::class.java)
    }

//    fun getService(): ApiService {
//        return service
//    }



}
