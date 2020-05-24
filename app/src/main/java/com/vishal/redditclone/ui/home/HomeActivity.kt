package com.vishal.redditclone.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vishal.redditclone.R
import com.vishal.redditclone.databinding.ActivityHomeBinding
import com.vishal.redditclone.ui.post.PostActivity


class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var homeViewModel: HomeViewModel
    lateinit var homeDataAdapter: HomeDataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        homeViewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                HomeViewModel::class.java
            )
        binding.lifecycleOwner = this
        binding.viewmodel = homeViewModel
        homeViewModel.initHomeViewModel()
        val recyclerView: RecyclerView = binding.viewEmployees
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        homeDataAdapter = HomeDataAdapter()
        recyclerView.adapter = homeDataAdapter
        homeViewModel.updateUi().observe(this, Observer {
            if (it != null) {
                homeDataAdapter.setPostList(it.redditFeedData?.children)
            } else {
                Toast.makeText(this, "Data null", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun click(url: String) {
        startActivity(Intent(this@HomeActivity, PostActivity::class.java).putExtra("link", url))
    }
}
