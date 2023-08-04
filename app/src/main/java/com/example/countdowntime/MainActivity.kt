package com.example.countdowntime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.countdowntime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            buttonStart.setOnClickListener {
                startCountDownTimer(20000)
            }
        }
    }
    private fun startCountDownTimer(timeMillis: Long) {
        timer?.cancel()
        timer = object: CountDownTimer(timeMillis, 1) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text = millisUntilFinished.toString()
            }

            override fun onFinish() {
                binding.tvTimer.text = "Finished"
            }

        }.start()
    }
}