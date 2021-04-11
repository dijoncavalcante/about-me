package com.dijon.aboutme

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.dijon.aboutme.databinding.ActivityFindMeBinding
import com.dijon.aboutme.presentation.base.BaseActivity

class FindMeActivity : BaseActivity() {
    private val TAG = "FindMeActivity"

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
        bindingFindMeActivity.carViewFindMeGmail.setOnClickListener { openSendEmail() }
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

    private fun openSendEmail() {
        val email =
            Intent(Intent.ACTION_SENDTO).apply {//garantir que o intent seja processado somente por um app de e-mails
                putExtra(
                    Intent.EXTRA_EMAIL,
                    arrayOf("dijoncavalcante@gmail.com")
                )
                putExtra(Intent.EXTRA_SUBJECT, "First contact by AboutApp")
                putExtra(Intent.EXTRA_TEXT, getString(R.string.message_hi_findme))
                setData(Uri.parse("mailto:"))// only email apps should handle this
//                setType("message/rfc822")//

            }
        if (email.resolveActivity(packageManager) != null) {
            startActivity(email)
            Log.d(TAG, "Start email")
        }
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