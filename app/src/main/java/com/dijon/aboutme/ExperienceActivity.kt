package com.dijon.aboutme

import androidx.appcompat.app.AppCompatActivity
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
    }
}