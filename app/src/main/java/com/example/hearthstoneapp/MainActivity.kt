package com.example.hearthstoneapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstoneapp.adapters.MainAdapter
import com.example.hearthstoneapp.model.info.Info
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Thread {
            val g = Gson()
            val d = Info(ArrayList())
            val info: Info = g.fromJson(fetchJson(), Info::class.java)
            var list = info.classes
            list.forEach { d.classes.add(it) }
            runOnUiThread{
                val adapter = MainAdapter(list)
                my_list.adapter = adapter
                my_list.layoutManager = LinearLayoutManager(this)
            }
        }.start()


    }

    fun fetchJson() : String? {
        println("Attempting to fetch JSON")

        val url = "https://omgvamp-hearthstone-v1.p.rapidapi.com/info"

        val request = Request.Builder()
            .url(url)
            .get()
            .addHeader("x-rapidapi-key", "0401a45eabmsh9c4b9e74c6108b2p18da99jsna4c4817ffe40")
            .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
            .build()

        val client = OkHttpClient()
        val response = client.newCall(request).execute()
        return response.body?.string()
    }


}