package com.example.recyclerviewlesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.recyclerviewlesson.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))
    }

    override fun onSupportNavigateUp(): Boolean {
        val controller = findNavController(R.id.fragmentContainerView)
        return controller.navigateUp() || super.onSupportNavigateUp()
    }
}