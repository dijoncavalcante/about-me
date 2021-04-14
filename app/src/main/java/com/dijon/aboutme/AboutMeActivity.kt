package com.dijon.aboutme

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.dijon.aboutme.databinding.ActivityAboutMeBinding
import com.dijon.aboutme.presentation.base.BaseActivity

class AboutMeActivity : BaseActivity() {

    private var askList = mutableListOf<String>()
    private var answerList = mutableListOf<String>()

    lateinit var bindingAboutMe: ActivityAboutMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingAboutMe = ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(bindingAboutMe.root)
        setupToolbar(bindingAboutMe.layoutInclude.toolbarMain, R.string.aboutme, true)

        postToList()

        bindingAboutMe.viewPager2AboutMe.adapter = AboutViewPagerAdapter(askList, answerList)
        bindingAboutMe.viewPager2AboutMe.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        bindingAboutMe.indicatorAboutMe.setViewPager(bindingAboutMe.viewPager2AboutMe)
    }

    private fun addToList(ask: String, answer: String) {
        askList.add(ask)
        answerList.add(answer)
    }

    private fun postToList() {
        addToList(getString(R.string.ask1), getString(R.string.answer1))
        addToList(getString(R.string.ask2), getString(R.string.answer2))
        addToList(getString(R.string.ask3), getString(R.string.answer3))
        addToList(getString(R.string.ask4), getString(R.string.answer4))
        addToList(getString(R.string.ask5), getString(R.string.answer5))
        addToList(getString(R.string.ask6), getString(R.string.answer6))
        addToList(getString(R.string.ask7), getString(R.string.answer7))
        addToList(getString(R.string.ask8), getString(R.string.answer8))
        addToList(getString(R.string.ask9), getString(R.string.answer9))
        addToList(getString(R.string.ask10), getString(R.string.answer10))
        addToList(getString(R.string.ask11), getString(R.string.answer10))
    }
}