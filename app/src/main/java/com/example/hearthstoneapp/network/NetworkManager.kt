package com.example.hearthstoneapp.network

import android.widget.Spinner
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.model.info.Info
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class NetworkManager {


    val client = OkHttpClient()

    val url = "https://omgvamp-hearthstone-v1.p.rapidapi.com/info"

    val request = Request.Builder()
        .url(url)
        .get()
        .addHeader("x-rapidapi-key", "0401a45eabmsh9c4b9e74c6108b2p18da99jsna4c4817ffe40")
        .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
        .build()

}