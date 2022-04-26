package com.example.twod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.twod.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var secondsLeft:Int = 1000  //倒數
    lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txv.text = secondsLeft.toString()
        binding.btnStart.isEnabled = true
        binding.btnStop.isEnabled = false

        binding.btnStart.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                //binding.txv.text = "開始倒數計時"

                job = GlobalScope.launch(Dispatchers.Main) {
                    while(secondsLeft > 0) {
                        secondsLeft--
                        binding.txv.text = secondsLeft.toString()
                        binding.btnStart.isEnabled = false
                        binding.btnStop.isEnabled = true
                        delay(25)   //延遲0.025秒
                    }
                }

            }
        })

        binding.btnStop.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                //binding.txv.text = "結束倒數計時"

                job.cancel()
                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = false
            }
        })
    }
}