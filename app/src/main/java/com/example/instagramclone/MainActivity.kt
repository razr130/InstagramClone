package com.example.instagramclone

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.instagramclone.Fragments.HomeFragment
import com.example.instagramclone.Fragments.NotificationFragment
import com.example.instagramclone.Fragments.ProfileFragment
import com.example.instagramclone.Fragments.SearchFragment

class MainActivity : AppCompatActivity() {


    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.navigation_home -> {

                    movetofragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true

                }
                R.id.navigation_search -> {
                    movetofragment(SearchFragment())
                    return@OnNavigationItemSelectedListener true

                }
                R.id.navigation_add -> {

                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    movetofragment(NotificationFragment())

                    return@OnNavigationItemSelectedListener true

                }
                R.id.navigation_profile -> {
                    movetofragment(ProfileFragment())
                    return@OnNavigationItemSelectedListener true

                }

            }

            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        movetofragment(HomeFragment())
    }

    private fun movetofragment(fragment: Fragment) {
        val fragmenttranst = supportFragmentManager.beginTransaction()
        fragmenttranst.replace(R.id.Frame_main, fragment)
        fragmenttranst.commit()
    }
}
