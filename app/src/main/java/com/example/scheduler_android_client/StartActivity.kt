package com.example.scheduler_android_client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.scheduler_android_client.R
import kotlinx.android.synthetic.main.start_activity.*

class StartActivity: AppCompatActivity(R.layout.start_activity) {

    override fun onBackPressed() {

        when(findNavController(R.id.navigationHost).currentDestination?.label) {
            "StartFragment" -> finish()
            "NfcFragment" -> finish()
            "SmartHomeFragment" -> finish()
            else -> super.onBackPressed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_smart_home -> {

                    findNavController(R.id.navigationHost).navigate(
                        R.id.smartHomeFragment
                    )
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {

                    findNavController(R.id.navigationHost).navigate(
                        R.id.startFragment
                    )
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_nfc -> {

                    findNavController(R.id.navigationHost).navigate(
                        R.id.nfcFragment
                    )
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

}