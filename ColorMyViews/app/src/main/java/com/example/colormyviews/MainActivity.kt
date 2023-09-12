package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
//        var one: View = findViewById(R.id.box_one_text)
//        var two: View = findViewById(R.id.box_two_text)
//        var three: View = findViewById(R.id.box_three_text)
//        var four: View = findViewById(R.id.box_four_text)
//        var five: View = findViewById(R.id.box_five_text)
//        var constraintLayout: View = findViewById(R.id.constraint_layout)

        val clickableViews: List<View> =
            listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText,
                binding.boxFourText, binding.boxFiveText, binding.constraintLayout,
                binding.redButton, binding.greenButton, binding.yellowButton)


        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when(view.id) {

            //Color class color
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.BLUE)

            //Android color resources
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_purple)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_red_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_blue_bright)

            //Custom color
            R.id.red_button -> binding.boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> binding.boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> binding.boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}