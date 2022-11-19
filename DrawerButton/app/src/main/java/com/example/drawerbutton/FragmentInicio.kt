package com.example.drawerbutton

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentInicio : Fragment(R.layout.fragment_inicio) {
    private lateinit var btnActivity:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnActivity = view.findViewById(R.id.btn_activity)
        btnActivity.setOnClickListener(){
            val ventana:Intent = Intent(context,ButtonActivity::class.java)
            startActivity(ventana)
        }
    }

    companion object {

    }
}