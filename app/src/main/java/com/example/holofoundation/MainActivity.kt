package com.example.holofoundation

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvidols: RecyclerView
    private val list = ArrayList<Idols>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvidols = findViewById(R.id.rvidols)
        rvidols.setHasFixedSize(true)

        list.addAll(listIdols)
        showRecyclerList()
    }

    private val listIdols: ArrayList<Idols>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataDetails = resources.getStringArray(R.array.data_details)
            val dataImage = resources.obtainTypedArray(R.array.data_image)
            val listIdols = ArrayList<Idols>()
            for (i in dataName.indices) {
                val idol = Idols(dataName[i], dataDescription[i], dataImage.getResourceId(i, -1),dataDetails[i])
                listIdols.add(idol)
            }
            return listIdols
        }
    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvidols.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvidols.layoutManager = LinearLayoutManager(this)
        }
        val listIdolAdapter = ListIdolAdapter(list)
        rvidols.adapter = listIdolAdapter

        listIdolAdapter.setOnItemClickCallback(object : ListIdolAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Idols) {
                showSelectedIdol(data)
            }
        })
    }
    private fun showSelectedIdol(idol: Idols) {
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_IDOL,idol)
        startActivity(intent)
    }
}