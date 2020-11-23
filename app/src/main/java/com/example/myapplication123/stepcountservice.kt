package com.example.myapplication123

import android.app.Service
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.localbroadcastmanager.content.LocalBroadcastManager


open class stepcountservice : Service(),SensorEventListener
{
    val TAG="stepcountservice"
    var sensorManager: SensorManager? = null
    var running = false
    var stepcount=0
    lateinit var updatesteps:updateUI
    lateinit var i1:Intent



    companion object
    {
        private lateinit var steps:stepcountservice
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
    {
        running = true

        val sensorManager: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val stepsSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepsSensor == null)
        {
            Toast.makeText(this, "No Step Counter Sensor !", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show()
        }
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (running)
        {

            val intent1 = Intent("myapplication")
            if (event != null)
            {
                stepcount = ((event.values[0]).toInt())
                intent1.putExtra("someName", stepcount)
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent1);

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show()
        Log.i("i","stopped")
        running = false
        sensorManager?.unregisterListener(this)
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }


}
