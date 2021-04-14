package com.dijon.aboutme

import android.content.Intent
import android.os.Bundle
import com.dijon.aboutme.databinding.ActivityExperienceBinding
import com.dijon.aboutme.presentation.base.BaseActivity

class ExperienceActivity : BaseActivity() {

    lateinit var bindingExperience: ActivityExperienceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingExperience = ActivityExperienceBinding.inflate(layoutInflater)
        setContentView(bindingExperience.root)

        setupToolbar(bindingExperience.layoutInclude.toolbarMain, R.string.experience, true)

        bindingExperience.buttonExperience.setOnClickListener { callFindMeActivity() }
    }

    private fun callFindMeActivity() {
        val intent = Intent(this, FindMeActivity::class.java)
        startActivity(intent)
    }
}