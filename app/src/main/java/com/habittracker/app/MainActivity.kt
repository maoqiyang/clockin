package com.habittracker.app

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import com.habittracker.app.databinding.ActivityMainBinding
import com.habittracker.app.ui.calendar.CalendarFragment
import com.habittracker.app.ui.home.HomeFragment
import com.habittracker.app.ui.motivation.MotivationFragment
import com.habittracker.app.ui.settings.SettingsFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        drawerLayout = binding.drawerLayout
        val navigationView: NavigationView = binding.navView
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.appBarMain.toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            navigationView.setCheckedItem(R.id.nav_home)
            supportActionBar?.title = getString(R.string.menu_home)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // 跳转到设置页面
                replaceFragment(SettingsFragment())
                supportActionBar?.title = getString(R.string.menu_settings)
                // 同时更新侧边栏的选中状态
                binding.navView.setCheckedItem(R.id.nav_settings)
                true
            }
            R.id.action_about -> {
                // 显示关于对话框
                showAboutDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: android.view.MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                replaceFragment(HomeFragment())
                supportActionBar?.title = getString(R.string.menu_home)
            }
            R.id.nav_calendar -> {
                replaceFragment(CalendarFragment())
                supportActionBar?.title = getString(R.string.menu_calendar)
            }
            R.id.nav_settings -> {
                replaceFragment(SettingsFragment())
                supportActionBar?.title = getString(R.string.menu_settings)
            }
            R.id.nav_motivation -> {
                replaceFragment(MotivationFragment())
                supportActionBar?.title = getString(R.string.menu_motivation)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, fragment)
            .commit()
    }

    private fun showAboutDialog() {
        val aboutMessage = """
            习惯打卡 v1.0

            一个帮助您建立和维持良好日常习惯的应用。

            主要功能：
            • 每日习惯打卡
            • 日历记录查看
            • 自定义习惯管理
            • 每日激励内容

            开发：Android Studio + Kotlin
            架构：MVVM + Room数据库

            © 2024 习惯打卡应用
        """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("关于应用")
            .setMessage(aboutMessage)
            .setIcon(R.mipmap.ic_launcher)
            .setPositiveButton("确定") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
