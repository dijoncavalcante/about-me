package com.dijon.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dijon.aboutme.databinding.ActivityFindMeBinding
import com.dijon.aboutme.databinding.ActivityMainBinding
import com.dijon.aboutme.presentation.base.BaseActivity

class FindMeActivity : BaseActivity() {

    lateinit var bindingFindMeActivity: ActivityFindMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingFindMeActivity = ActivityFindMeBinding.inflate(layoutInflater)
        setContentView(bindingFindMeActivity.root)

        setupToolbar(bindingFindMeActivity.layoutInclude.toolbarMain, R.string.findMe, true)
    }
}