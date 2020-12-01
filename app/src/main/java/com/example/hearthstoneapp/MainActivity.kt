package com.example.hearthstoneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hearthstoneapp.model.info.Info
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchJson()
    }

    fun fetchJson() {
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

                val info: Info = gson.fromJson(body, Info::class.java)
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }
}