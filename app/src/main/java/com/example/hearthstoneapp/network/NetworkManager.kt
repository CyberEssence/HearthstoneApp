package com.example.hearthstoneapp.network

import android.widget.Spinner
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.model.info.Info
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

open class NetworkManager {

    lateinit var spinner: Spinner

    fun fetchJson(list: ArrayList<Info>){
        println("Attempting to fetch JSON")

        val url = "https://omgvamp-hearthstone-v1.p.rapidapi.com/info"

        val request = Request.Builder()
            .url(url)
            .get()
            .addHeader("x-rapidapi-key", "0401a45eabmsh9c4b9e74c6108b2p18da99jsna4c4817ffe40")
            .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)


                val gson = GsonBuilder().create()
                var i = 0
                val packageList = gson.fromJson(body, list::class.java).toList()

            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }
}