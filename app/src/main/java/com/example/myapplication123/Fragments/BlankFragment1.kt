package com.example.myapplication123.Fragments

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.content.SharedPreferences
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.myapplication123.R
import kotlinx.android.synthetic.main.fragment_home.*


class BlankFragment1 : Fragment(),SensorEventListener
{
    private var sensorManager: SensorManager?= null
    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f
    lateinit var sharedPreferences: SharedPreferences

    

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =inflater.inflate(R.layout.fragment_blank1, container, false)
        loadData()
        resetSteps()
        sensorManager = requireActivity().getSystemService(SENSOR_SERVICE) as SensorManager



        return view
    }


    override fun onResume() {
        super.onResume()
        running = true
        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        if (stepSensor == null) {
            Toast.makeText(activity, "No sensor detected on this device", Toast.LENGTH_SHORT).show()
        }else{
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(running ){
            totalSteps = event!!.values[0]
            val currentSteps: Int = totalSteps.toInt() - previousTotalSteps.toInt()
            tv_stepsTaken.text = ("$currentSteps")

            progress_circular.apply{
                setProgressWithAnimation(currentSteps.toFloat())
            }

        }
    }

    private fun resetSteps(){
        tv_stepsTaken.setOnClickListener {
            Toast.makeText(activity, "Long tap to reset steps", Toast.LENGTH_SHORT).show()
        }
        tv_stepsTaken.setOnLongClickListener{
            previousTotalSteps = totalSteps

            tv_stepsTaken.text= 0.toString()
            saveData()

            true

        }
    }

    private fun saveData()
    {
       /* val preferences = this.requireActivity()
            .getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        //val editor = this.
            //.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putFloat("key1", previousTotalSteps)
        editor.apply()
        */
        sharedPreferences = (activity as FragmentActivity).getSharedPreferences(
            getString(R.string.myPrefs),
            Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putFloat("key1", previousTotalSteps)
        editor.apply()
    }

    private fun loadData()
    {
        sharedPreferences = (activity as FragmentActivity).getSharedPreferences(
            getString(R.string.myPrefs),
            Context.MODE_PRIVATE
        )
        val savedNumber = sharedPreferences.getFloat("key1",0f)
        Log.d("MainActivity", "$savedNumber")
        previousTotalSteps = savedNumber
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }


}