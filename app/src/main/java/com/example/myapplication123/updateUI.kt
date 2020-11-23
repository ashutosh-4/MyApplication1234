package com.example.myapplication123

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class updateUI(stepvalues1: Int) : BroadcastReceiver()
{
    private val TAG = "StartupReceiver"


    override fun onReceive(context: Context?, intent: Intent) {
        Log.i(
            TAG, "Received broadcast intent: " +
                    intent.action
        )
    }


}