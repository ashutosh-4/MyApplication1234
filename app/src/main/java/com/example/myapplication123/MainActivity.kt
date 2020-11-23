package com.example.myapplication123

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication123.Fragments.healthFragment
import com.example.myapplication123.Fragments.homeFragment
import com.example.myapplication123.Fragments.reportFragment
import com.example.myapplication123.Fragments.settingsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


class MainActivity : AppCompatActivity() {

    private val homefragment= homeFragment()
    private val reportfragment=reportFragment()
    private val healthfragment= healthFragment()
    private val settingsfragment= settingsFragment()


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment()

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId)
            {
                R.id.menu_home -> replaceFragment1()
                R.id.menu_report -> replaceFragment2()
                R.id.menu_health -> replaceFragment3()
                R.id.menu_settings -> replaceFragment4()
            }
            true
        }
    }

    private fun replaceFragment()
    {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container,homefragment)
        ft.commit()
    }

    private fun replaceFragment1()
    {
        val ft = supportFragmentManager.beginTransaction()
        if (homefragment.isAdded) {
            ft.show(homefragment)
        } else {
            ft.add(R.id.fragment_container, homefragment)
        }

        if (reportfragment.isAdded) { ft.hide(reportfragment)}

        if (healthfragment.isAdded) { ft.hide(healthfragment)}
        if (settingsfragment.isAdded) { ft.hide(settingsfragment)}

        ft.commit()
    }
    private fun replaceFragment2()
    {
        val ft = supportFragmentManager.beginTransaction()
        if (reportfragment.isAdded) {
            ft.show(reportfragment)
        } else {
            ft.add(R.id.fragment_container, reportfragment)
        }

        if (homefragment.isAdded) { ft.hide(homefragment) }

        if (healthfragment.isAdded) { ft.hide(healthfragment)}
        if (settingsfragment.isAdded) { ft.hide(settingsfragment)}

        ft.commit()
    }
    private fun replaceFragment3()
    {
        val ft = supportFragmentManager.beginTransaction()
        if (healthfragment.isAdded) {
            ft.show(healthfragment)
        } else {
            ft.add(R.id.fragment_container, healthfragment)
        }

        if (reportfragment.isAdded) { ft.hide(reportfragment) }

        if (homefragment.isAdded) { ft.hide(homefragment) }
        if (settingsfragment.isAdded) { ft.hide(settingsfragment)}

        ft.commit()
    }
    private fun replaceFragment4()
    {
        val ft = supportFragmentManager.beginTransaction()

        if (settingsfragment.isAdded)
        {
            ft.show(settingsfragment)
        }
        else
        {
            ft.add(R.id.fragment_container, settingsfragment)
        }
        if (reportfragment.isAdded) { ft.hide(reportfragment) }
        if (healthfragment.isAdded) { ft.hide(healthfragment) }
        if (homefragment.isAdded) { ft.hide(homefragment) }
        ft.commit()
    }



}