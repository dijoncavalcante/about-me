package com.dijon.aboutme

import android.os.Bundle
import com.dijon.aboutme.databinding.ActivityDegreeBinding
import com.dijon.aboutme.presentation.base.BaseActivity

class DegreeActivity : BaseActivity() {

    lateinit var bindingDegree: ActivityDegreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingDegree = ActivityDegreeBinding.inflate(layoutInflater)
        setContentView(bindingDegree.root)

        setupToolbar(bindingDegree.layoutInclude.toolbarMain, R.string.backgroud, true)
    }
}