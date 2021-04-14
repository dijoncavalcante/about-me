package com.dijon.aboutme

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
            Toast.makeText(this, "WhatsApp not installed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openLinkedIn() {
        val openIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(getString(R.string.uri_linkedin))
        )
        startActivity(openIntent)
    }

    private fun openGithub() {
        val openIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(getString(R.string.uri_github))
        )
        startActivity(openIntent)
    }

    private fun openSendEmail() {
        val email =
            Intent(Intent.ACTION_SENDTO).apply {//garantir que o intent seja processado somente por um app de e-mails
                putExtra(
                    Intent.EXTRA_EMAIL,
                    arrayOf(getString(R.string.gmail_dijoncavalcante_gmail_com))
                )
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject))
                putExtra(Intent.EXTRA_TEXT, getString(R.string.message_hi_findme))
                setData(Uri.parse("mailto:"))
            }
        if (email.resolveActivity(packageManager) != null) {
            startActivity(email)
            Log.d(TAG, "Start email")
        }
    }

    private fun openTwitter() {
        val openIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(getString(R.string.uri_twitter))
        )
        startActivity(openIntent)
    }

    private fun openIntagran() {
        val openIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(getString(R.string.uri_instagram))
        )
        startActivity(openIntent)
    }
}