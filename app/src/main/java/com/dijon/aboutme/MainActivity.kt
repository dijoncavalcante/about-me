package com.dijon.aboutme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val iv_experience =findViewById<ImageView>(R.id.iv_experience)
        iv_experience.setOnClickListener {
            val intent = Intent(this, ExperienceActivity::class.java).apply {
                startActivity(intent)
            }
        }
    }


}