package io.github.tuguzt.theonewhowaits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.tuguzt.theonewhowaits.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
