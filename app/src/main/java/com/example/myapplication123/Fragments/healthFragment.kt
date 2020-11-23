package com.example.myapplication123.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication123.R


class healthFragment : Fragment()
{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        view?.setBackgroundColor(Color.GREEN)

        return inflater.inflate(R.layout.fragment_health, container, false)
    }

}