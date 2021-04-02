package com.dijon.aboutme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.dijon.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.layoutRoot.carViewAbout.setOnClickListener { callExperienceActivity() }
        binding.layoutRoot.carViewBackground.setOnClickListener { callExperienceActivity() }
        binding.layoutRoot.carViewExperience.setOnClickListener { callExperienceActivity() }
        binding.layoutRoot.carViewFindMe.setOnClickListener { callExperienceActivity() }

    }

    private fun callExperienceActivity() {
        val intent = Intent(this, ExperienceActivity::class.java)
        startActivity(intent)
    }
}