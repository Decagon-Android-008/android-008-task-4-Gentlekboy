package com.gentlekboy.birthdayapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fragmentManager.beginTransaction().replace(R.id.frame_layout, HomeFragment(), "Fragment 1").commit()

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemSelectedListener(navListener)
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        var selectedFragment: Fragment? = null

        when(item.itemId){
            R.id.homeMenu -> {
                selectedFragment = HomeFragment()
            }
            R.id.peopleMenu -> {
                selectedFragment = PeopleFragment()
            }
            R.id.giftMenu -> {
                selectedFragment = GiftFragment()
            }
        }
        if (selectedFragment != null) {
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, selectedFragment).commit()
        }
        return@OnNavigationItemSelectedListener true
    }
}