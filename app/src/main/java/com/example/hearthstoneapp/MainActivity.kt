package com.example.hearthstoneapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.hearthstoneapp.model.info.Info
import com.example.hearthstoneapp.network.NetworkManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_item_spinner_class.*
import kotlinx.android.synthetic.main.custom_item_spinner_race.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Thread {
            val g = Gson()
            val d = Info(ArrayList(), ArrayList())
            val info: Info = g.fromJson(NetworkManager().fetchJson(), Info::class.java)
            var listOfClasses = info.classes
            //listOfClasses.add("All classes")
            listOfClasses.forEach { d.classes.add(it) }
            var listOfRaces = info.races
            //listOfRaces.add("All races")
            listOfRaces.forEach { d.races.add(it) }

            runOnUiThread{
                val arrayAdapterOfClasses = ArrayAdapter(this, R.layout.custom_item_spinner_class, R.id.class_text, listOfClasses)
                customSpinnerClasses.adapter = arrayAdapterOfClasses

                val arrayAdapterOfRaces = ArrayAdapter(this, R.layout.custom_item_spinner_race, R.id.race_text, listOfRaces)
                customSpinnerRaces.adapter = arrayAdapterOfRaces

                customSpinnerClasses.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(p0: AdapterView<*>?) {
                    }

                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        class_text.text = listOfClasses[p2]
                    }
                }

                customSpinnerRaces.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(p0: AdapterView<*>?) {
                    }

                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        race_text.text = listOfRaces[p2]
                    }
                }
            }
        }.start()


    }

}