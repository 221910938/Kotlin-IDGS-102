package com.example.projectoangel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.projectoangel.config.AppDatabase
import com.example.projectoangel.databinding.ActivityMainBinding
import com.example.projectoangel.models.Horario
import com.example.projectoangel.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get()
        viewModel.iniciar()

    }

}