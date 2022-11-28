package com.example.projectoangel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projectoangel.databinding.ActivityMainBinding

class Main : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var usuario = binding.usuario.text.toString()

        var password = binding.password.text.toString()

        binding.button.setOnClickListener{
            Log.d("message",usuario + password)
            if (usuario.equals("al221910938@gmail.com") && password.equals("123456789"))
            {
                Log.d("message","Inicio Exitoso")
                val intent = Intent(this,Menu::class.java)
                startActivity(intent)
            }
        }

    }

}