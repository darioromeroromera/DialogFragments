package com.example.dialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dialogfragment.controller.Controller
import com.example.dialogfragment.databinding.ActivityMainBinding
import kotlin.coroutines.Continuation

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initController()
    }

    fun initController() {
        val controller = Controller(this)
    }
}