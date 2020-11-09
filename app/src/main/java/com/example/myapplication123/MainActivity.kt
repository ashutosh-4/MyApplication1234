package com.example.myapplication123

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication123.Fragments.healthFragment
import com.example.myapplication123.Fragments.homeFragment
import com.example.myapplication123.Fragments.reportFragment
import com.example.myapplication123.Fragments.settingsFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
{

    private val homefragment=homeFragment()
    private val reportfragment=reportFragment()
    private val healthfragment= healthFragment()
    private val settingsfragment= settingsFragment()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homefragment)

        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId)
            {
                R.id.menu_home -> replaceFragment(homefragment)
                R.id.menu_report -> replaceFragment(reportfragment)
                R.id.menu_health -> replaceFragment(healthfragment)
                R.id.menu_settings -> replaceFragment(settingsfragment)

            }
            true
        }

    }
    
    private fun replaceFragment(fragment:Fragment)
    {
        if(fragment != null)
        {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}