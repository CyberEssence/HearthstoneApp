package com.example.hearthstoneapp.presentation

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.databinding.ActivityMainBinding
import com.example.hearthstoneapp.presentation.allcards.AllCardsActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var scaleUp: Animation
    private lateinit var scaleDown: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down)

        binding.allCardsButton.setOnTouchListener { view, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN) {
                all_cards_button.startAnimation(scaleUp)
            } else if(motionEvent.action == MotionEvent.ACTION_UP) {
                all_cards_button.startAnimation(scaleDown)
                val intent = Intent(this, AllCardsActivity::class.java)
                startActivity(intent)
            }

            return@setOnTouchListener true
        }
    }


}