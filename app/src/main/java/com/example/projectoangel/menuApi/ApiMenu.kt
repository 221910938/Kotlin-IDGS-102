package com.example.projectoangel.menuApi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.projectoangel.adapter.ActividadAdapter
import com.example.projectoangel.databinding.ActivityApiMenuBinding
import com.example.projectoangel.models.Actividad
import com.google.gson.Gson
import org.json.JSONObject

class ApiMenu : AppCompatActivity() {
    lateinit var binding: ActivityApiMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

        binding.btnApiCrear.setOnClickListener {
            val intent = Intent(this, ApiCrear::class.java)
            startActivity(intent)
        }

    }

    fun getData() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.1.75:8000/api/actividades/"

        var listaActividad = listOf<Actividad>()
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val json = JSONObject(response)
                var json2 = json.getJSONArray("response")
                listaActividad = Gson().fromJson(json2.toString(), Array<Actividad>::class.java).toList()
                initRecyclerView(listaActividad)
            },
            {
                Log.d("message", "error")
            })
        queue.add(stringRequest)
    }

    fun initRecyclerView(Actividades: List<Actividad>) {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ActividadAdapter(Actividades,this)
    }
}