package com.example.myapplication123.Fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication123.R
import com.example.myapplication123.stepcountservice
import com.example.myapplication123.updateUI
import kotlinx.android.synthetic.main.fragment_home.*


class homeFragment : Fragment(),View.OnClickListener
{
    private lateinit var buttonstart1: Button
    private lateinit var buttonstop1: Button
    private lateinit var updatesteps:updateUI

    private val broadCastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            var s1="0"
            if (intent != null) {
                s1= intent.getStringExtra("somename").toString()
            }
            stepsValue1.text = s1
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view=inflater.inflate(R.layout.fragment_home, container, false)
        buttonstart1=view.findViewById(R.id.buttonstart)
        buttonstop1=view.findViewById(R.id.buttonstop)

        buttonstart1.setOnClickListener(this)
        buttonstop1.setOnClickListener(this)



        return view
    }

    override fun onClick(view: View)
    {
        if(view == buttonstart1)
        {
            activity?.registerReceiver(broadCastReceiver, IntentFilter("myapplication"))
            activity?.startService(Intent(activity, stepcountservice::class.java))
        }
        else if(view == buttonstop1)
        {
            activity?.unregisterReceiver(broadCastReceiver)
            activity?.stopService(Intent(activity, stepcountservice::class.java))
        }
    }



}