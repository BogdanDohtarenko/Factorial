package com.ideasapp.factorial

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.ideasapp.factorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        observeViewModel()
        binding.buttonCalculate.setOnClickListener {
            viewModel.calculateFactorial(binding.editTextNumber.text.toString())
        }
    }

    private fun observeViewModel() {
        viewModel.state.observe(this) {
            when(it) {
                is Error -> {
                    Toast.makeText(
                        this,
                        "You did not entered value",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is Progress -> {
                    binding.progressBarLoading.visibility = View.VISIBLE
                    binding.buttonCalculate.isEnabled = false
                }
                is Result -> {
                    binding.textViewFactorial.text = it.factorial
                }
            }
        }
    }
}