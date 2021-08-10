package raf.rs.projekatjun.nikola_paunovic_5718rn.presentation.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import raf.rs.projekatjun.nikola_paunovic_5718rn.R
import raf.rs.projekatjun.nikola_paunovic_5718rn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        initUi()
    }

    private fun initUi() {
        binding.addEvent.setOnClickListener{
            startActivity(Intent(this, NewEventActivity::class.java))
            finish()
        }
    }
}