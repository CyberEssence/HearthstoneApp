package com.example.hearthstoneapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstoneapp.adapters.DataAdapter
import com.example.hearthstoneapp.model.cards.Basic
import com.example.hearthstoneapp.model.cards.Basics
import com.example.hearthstoneapp.model.cards.Cards
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    private var basics = ArrayList<Basic>()
    var basic : Basics = Basics(basics)
    lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        adapter.notifyDataSetChanged()

        sendNetworkRequest(basic)
    }

    @SuppressLint("WrongConstant")
    private fun initViews() {
        recyclerView = findViewById(R.id.imageCard)
        recyclerView.setHasFixedSize(true)
        adapter = DataAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }



    private fun sendNetworkRequest(card: Basics) {

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

        val client = retrofit.create(GetCardService::class.java)
        val call = client.getAllCards()
        call.enqueue(object: Callback<Basics> {

            override fun onResponse(call: Call<Basics>?, response: Response<Basics>?) {
//                val cardResponse: Card? = response.body()
//                val data = ArrayList(Arrays.asList(cardResponse?.img))
//                adapter = DataAdapter(context, cards)
//                recyclerView.adapter = adapter
//                if (response?.body() != null)
//                    adapter.setUsersListItems(response.body()!!)
                if (response != null) {
                    if(response.isSuccessful) {
                        d("response", response.body().toString())
                    } else {
                        d("response code", response.code().toString())
                    }

                }
            }

            override fun onFailure(call: Call<Basics>, t: Throwable) {
                d("error", t.toString())
            }
        })
    }

}