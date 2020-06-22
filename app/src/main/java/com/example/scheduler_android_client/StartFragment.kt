package com.example.scheduler_android_client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation

import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment: Fragment(R.layout.start_fragment) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        start_fragment_movies_button.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_moviesFragment)
        }

        start_fragment_shoping_button.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_shoppingFragment)
        }

        start_fragment_notifications_button.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_notificationsFragment)
        }
    }
}