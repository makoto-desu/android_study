package com.example.makotosampleapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("takahiron/sampletest/master/test-json.json")
    fun getNoticeList(): Call<NoticeList>

}