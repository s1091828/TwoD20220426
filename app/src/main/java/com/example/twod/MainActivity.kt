package com.example.twod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.twod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var secondsLeft:Int = 1000  //倒數

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txv.text = secondsLeft.toString()
        binding.btnStart.isEnabled = true
        binding.btnStop.isEnabled = false
    }
}