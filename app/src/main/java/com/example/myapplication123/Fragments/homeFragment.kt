package com.example.myapplication123.Fragments

import android.content.Context
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.myapplication123.R


class homeFragment : Fragment() {

    private var sensorManager:SensorManager?=null

    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}