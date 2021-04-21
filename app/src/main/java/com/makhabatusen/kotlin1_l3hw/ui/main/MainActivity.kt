package com.makhabatusen.kotlin1_l3hw.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.makhabatusen.kotlin1_l3hw.R
import com.makhabatusen.kotlin1_l3hw.databinding.ActivityMainBinding
import com.makhabatusen.kotlin1_l3hw.ui.adapters.MenuBottomNavAdapter
import com.makhabatusen.kotlin1_l3hw.ui.fragments.fragment_count_result.CountResultFragment
import com.makhabatusen.kotlin1_l3hw.ui.fragments.fragment_home.HomeFragment
import com.makhabatusen.kotlin1_l3hw.ui.fragments.fragment_text_operations.TextOperationsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var ui: ActivityMainBinding
    private lateinit var menuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)
        init()
    }

    private fun init() {
        val menuBottomNavAdapter =
            MenuBottomNavAdapter(initFragments(), supportFragmentManager, lifecycle)
        ui.viewPager.adapter = menuBottomNavAdapter
        ui.navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_one -> {
                    ui.viewPager.currentItem = 0
                }
                R.id.item_two -> {
                    ui.viewPager.currentItem = 1
                }
                R.id.item_three -> {
                    ui.viewPager.currentItem = 2
                }
            }
            true
        }

        ui.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (::menuItem.isInitialized)
                    menuItem.isChecked = false
                else
                    ui.navigationView.menu[0].isChecked = false
                ui.navigationView.menu[position].isChecked = true
                menuItem = ui.navigationView.menu.getItem(position)
            }
        })
    }

    private fun initFragments(): ArrayList<Fragment> {
        return arrayListOf(
            HomeFragment(),
            CountResultFragment(),
            TextOperationsFragment()
        )
    }
}