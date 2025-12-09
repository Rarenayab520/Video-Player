package com.nayab.bottomnavigation

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ------------------ FIND VIEWS ------------------
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.navigation_view)
        toolbar = findViewById(R.id.toolbar)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        // ------------------ TOOLBAR ------------------
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.nav_open,
            R.string.nav_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // ------------------ TAB + VIEWPAGER SETUP ------------------
        viewPager.adapter = TabsAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Home"
                1 -> "Explore"
                2 -> "About"
                3 -> "Profile"
                else -> "Tab"
            }
        }.attach()

        // ------------------ DRAWER NAV CLICKS ------------------
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> viewPager.currentItem = 0
                R.id.nav_explore -> viewPager.currentItem = 1
                R.id.nav_about -> viewPager.currentItem = 2
                R.id.nav_profile -> viewPager.currentItem = 3
                R.id.nav_logout -> finish()
            }

            drawerLayout.closeDrawers()
            true
        }
    }
}
