package com.example.drawerbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.internal.NavigationMenuItemView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toogle:ActionBarDrawerToggle
    private lateinit var dlView:DrawerLayout
    private lateinit var navView:NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dlView = findViewById(R.id.drawer_layout_view)
        navView = findViewById(R.id.drawerl_navigation_view)
        toogle = ActionBarDrawerToggle(this,dlView,R.string.open_drawer,R.string.close_drawer)

        toogle?.syncState() //nuestro fragment se sincronice con el elemento con el drawer navigation view

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener{ menuItem ->
            when(menuItem.itemId){
                R.id.menu_home ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.drawel_frag_container_view,FragmentInicio())
                        commit()
                    }
                }
                R.id.menu_camera ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.drawel_frag_container_view,FragmentCamara())
                        commit()
                    }
                }
                R.id.menu_galeria ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.drawel_frag_container_view,FragmentGaleria())
                        commit()
                    }
                }
                R.id.menu_message ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.drawel_frag_container_view,FragmentMensajes())
                        commit()
                    }
                }
            }
            dlView.closeDrawer(GravityCompat.START)
            true
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)){
            return true
        }else{
            return super.onOptionsItemSelected(item)
        }
    }

}