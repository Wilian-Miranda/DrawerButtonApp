package com.example.drawerbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ButtonActivity : AppCompatActivity() {
    private lateinit var btnMenu:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        var homeFragment = FragmentInicio()
        var mensajeFragment = FragmentMensajes()
        var perfilFragment = PerfilFragment()

        setCurrentFragment(homeFragment)
        btnMenu = findViewById(R.id.ab_fragCV_btnNav)
        btnMenu.setOnNavigationItemReselectedListener{ menuItem->
            when(menuItem.itemId){
                R.id.btn_nav_menu_home -> {
                    setCurrentFragment(homeFragment)
                }
                R.id.btn_nav_menu_message -> {
                    setCurrentFragment(mensajeFragment)
                }
                R.id.btn_nav_menu_perfil -> {
                    setCurrentFragment(perfilFragment)
                }
            }
        }
    }

    private fun setCurrentFragment(_fragment:Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.ab_fragCV,_fragment)
        commit()
    }
}