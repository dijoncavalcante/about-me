package com.dijon.aboutme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dijon.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.layoutRoot.carViewAbout.setOnClickListener { callAboutMeActivity() }
        binding.layoutRoot.carViewBackground.setOnClickListener { callDegreeActivity() }
        binding.layoutRoot.carViewExperience.setOnClickListener { callExperienceActivity() }
        binding.layoutRoot.carViewFindMe.setOnClickListener { callFindMeActivity() }

    }

    private fun callExperienceActivity() {
        val intent = Intent(this, ExperienceActivity::class.java)
        startActivity(intent)
    }

    private fun callAboutMeActivity() {
        val intent = Intent(this, AboutMeActivity::class.java)
        startActivity(intent)
    }

    private fun callDegreeActivity() {
        val intent = Intent(this, DegreeActivity::class.java)
        startActivity(intent)
    }

    private fun callFindMeActivity() {
        val intent = Intent(this, FindMeActivity::class.java)
        startActivity(intent)
    }
}