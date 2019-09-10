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


    internal var selectedfragment: Fragment? = null

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.navigation_home -> {

                    selectedfragment = HomeFragment()

                }
                R.id.navigation_search -> {

                    selectedfragment = SearchFragment()
                }
                R.id.navigation_add -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    selectedfragment = NotificationFragment()
                }
                R.id.navigation_profile -> {
                    selectedfragment = ProfileFragment()
                }

            }
            if(selectedfragment !=null){
                supportFragmentManager.beginTransaction().replace(R.id.Frame_main,selectedfragment!!).commit()

            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().replace(R.id.Frame_main,HomeFragment()).commit()

    }
}
