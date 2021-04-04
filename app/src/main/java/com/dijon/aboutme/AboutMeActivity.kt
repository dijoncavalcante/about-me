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

    private fun postToList_() {
        for (i in 1..5) {
            addToList("Pergunta: $i", "Resposta: $i")
        }
    }

    private fun postToList() {
        addToList("Qual é o meu nome?", "Meu nome é Dijon Cavalcante Braga.")
        addToList("Qual é a minha idade?", "Eu tenho 30 anos de idade.")
        addToList("Eu sou casado?", "SIM! Eu sou casado há 6 anos.")
        addToList("Qual é a minha profissão?", "Atualmente eu sou Engenheiro de Software no Sidia Instituto de Ciência e Tecnologia, fica localizado em Manaus/Amazonas.")
        addToList("Em que eu sou graduado?", "Eu sou Baicharel em Ciência da Computação.")
        addToList("Onde eu nasci?", "Eu nasci em Manaus/Amazonas")
        addToList("Qual é o meu nome?", "Meu")
        addToList("Qual é o meu nome?", "Meu")
        addToList("Qual é o meu nome?", "Meu")
        addToList("Qual é o meu nome?", "Meu")
        addToList("Qual é o meu nome?", "Meu")
        addToList("Qual é o meu nome?", "Meu")
        addToList("Qual é o meu nome?", "Meu")
    }

}