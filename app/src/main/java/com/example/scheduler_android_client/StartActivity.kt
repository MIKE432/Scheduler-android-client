package com.example.scheduler_android_client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.start_activity.*

class StartActivity: AppCompatActivity(R.layout.start_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_smart_home -> {

                    findNavController(R.id.navigationHost).navigate(R.id.smartHomeFragment)
                    true
                }
                R.id.navigation_dashboard -> {

                    findNavController(R.id.navigationHost).navigate(R.id.startFragment)
                    true
                }
                R.id.navigation_nfc -> {
                    findNavController(R.id.navigationHost).navigate(R.id.nfcFragment)


                    true
                }
                else -> false
            }
        }
    }

}