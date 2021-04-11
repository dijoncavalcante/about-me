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

        bindingFindMeActivity.carViewFindMeCall.setOnClickListener { openCaller() }
        bindingFindMeActivity.carViewFindMeWpp.setOnClickListener { openWhatsApp() }
        bindingFindMeActivity.carViewFindMeLinkedin.setOnClickListener { openLinkedIn() }
        bindingFindMeActivity.carViewFindMeGithub.setOnClickListener { openGithub() }
        bindingFindMeActivity.carViewFindMeTwitter.setOnClickListener { openTwitter() }
        bindingFindMeActivity.carViewFindMeInstagram.setOnClickListener { openIntagran() }
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

    private fun openCaller() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("tel:${getString(R.string.myCelphoneNumberwithDDD)}")
        startActivity(intent)
    }

    private fun openWhatsApp() {
        val isAppInstalled = appInstalledOrNot("com.whatsapp")
        if (isAppInstalled) {
            val openIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(
                    "https://api.whatsapp.com/send?phone=${getString(R.string.myCelphoneNumberwithDDD)}&text=${
                        getString(
                            R.string.message_hi_findme
                        )
                    }"
                )
            )
            startActivity(openIntent)
        } else {
            // WhatsApp not installed show toast or dialog
        }
    }

    private fun openLinkedIn() {
        val openIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.linkedin.com/in/dijon-braga-9a5b3911a")
        )
        startActivity(openIntent)
    }

    private fun openGithub() {
        val openIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://github.com/dijoncavalcante")
        )
        startActivity(openIntent)
    }

    private fun openTwitter() {
        val openIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://twitter.com/DijonBraga")
        )
        startActivity(openIntent)
    }

    private fun openIntagran() {
        val openIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.instagram.com/dijonbraga/")
        )
        startActivity(openIntent)
    }

}