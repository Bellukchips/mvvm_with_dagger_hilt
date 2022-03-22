package com.bellukstudio.learn_mvvm

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterGithub: AdapterGithub
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycle()
        initViewModel()

    }
    private fun initRecycle(){
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if(it != null){
                adapterGithub = AdapterGithub()
                recyclerView.adapter = adapterGithub
                adapterGithub.setData(it)
                adapterGithub.notifyDataSetChanged()
            }else{
                Toast.makeText(this, "Error in getting data",Toast.LENGTH_LONG).show()
            }
        })
        viewModel.loadListOfData()
    }
}