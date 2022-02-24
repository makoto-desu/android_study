package com.example.makotosampleapp

data class Notice(
    var id: Int,
    var title: String,
    var description: String,
    var image: String
)

data class NoticeList(
    var data: ArrayList<Notice>
)
