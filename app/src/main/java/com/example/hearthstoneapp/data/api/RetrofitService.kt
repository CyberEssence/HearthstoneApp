package com.example.hearthstoneapp.data.api

import android.util.Log
import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.data.model.Basic
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class RetrofitService {

    fun sendNetworkRequest(card: ArrayList<AllCards>) {

        val okhttpBuilder = OkHttpClient.Builder()

        okhttpBuilder.addInterceptor { chain ->
            val original = chain.request()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                .addHeader("x-rapidapi-key", "0401a45eabmsh9c4b9e74c6108b2p18da99jsna4c4817ffe40")
                .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        val builder = Retrofit.Builder()
            .baseUrl("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
            .client(okhttpBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())

        val retrofit = builder.build()

        val client = retrofit.create(HearthstoneService::class.java)
        val call = client.getAllCards()
        call.enqueue(object: Callback<Basic> {

            override fun onResponse(call: Call<Basic>?, response: Response<Basic>?) {
//                val cardResponse: Card? = response.body()
//                val data = ArrayList(Arrays.asList(cardResponse?.img))
//                adapter = DataAdapter(context, cards)
//                recyclerView.adapter = adapter
//                if (response?.body() != null)
//                    adapter.setUsersListItems(response.body()!!)
                if (response != null) {
                    if(response.isSuccessful) {
                        Log.d("response", response.body()?.Basic?.get(0).toString())
                    } else {
                        Log.d("response code", response.code().toString())
                    }

                }
            }

            override fun onFailure(call: Call<Basic>, t: Throwable) {
                Log.d("error", t.toString())
            }
        })
    }
}