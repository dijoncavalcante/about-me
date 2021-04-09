package com.dijon.aboutme

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import com.dijon.aboutme.databinding.ActivityFindMeBinding
import com.dijon.aboutme.presentation.base.BaseActivity

class FindMeActivity : BaseActivity() {

    lateinit var bindingFindMeActivity: ActivityFindMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingFindMeActivity = ActivityFindMeBinding.inflate(layoutInflater)
        setContentView(bindingFindMeActivity.root)

        setupToolbar(bindingFindMeActivity.layoutInclude.toolbarMain, R.string.findMe, true)

        bindingFindMeActivity.carViewFindMeWpp.setOnClickListener { openWhatsApp() }


    }

    private fun openCaller() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:5592993210558")
        startActivity(intent)
    }

    private fun openWhatsApp() {
        val isAppInstalled = appInstalledOrNot("com.whatsapp")
        if (isAppInstalled) {
            val openIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://api.whatsapp.com/send?phone=5592993210558&text=${getString(R.string.message_hi_findme)}")
            )
            startActivity(openIntent)
        } else {
            // WhatsApp not installed show toast or dialog
        }
    }

    private fun appInstalledOrNot(uri: String): Boolean {
        val pm = packageManager;
        return try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}