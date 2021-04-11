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
        addToList("Qual é o meu nome?", "Eu sou Dijon Braga.")
        addToList("Qual é a minha idade?", "Eu tenho 30 anos de idade.")
        addToList("Eu sou casado?", "SIM! Eu sou casado há 6 anos. Ainda não tenho filhos, mas desejo ter no momento certo.")
        addToList("Qual é a minha profissão?", "Atualmente eu sou Engenheiro de Software no Sidia Instituto de Ciência e Tecnologia, fica localizado em Manaus/Amazonas/Brasil.")
        addToList("Em que eu sou graduado?", "Eu sou Baicharel em Ciência da Computação.")
        addToList("Onde eu nasci?", "Eu nasci em Manaus/Amazonas/Brasil.")
        addToList("Qual meu hobby?", "Bem, eu gosto de jogar video game, gosto de futebol também.")
        addToList("Quais linguagens de programação eu ja trabalhei?", "Atualmente eu trabalho com Java atuando dentro do campo de android embarcado, mas eu iniciei trabalhando com Java EE, logo migrei para .Net[desktop], fiz muitas muitas conversões de tela de Visual Basic 6(VB6) para .Net e criei muitos sistemas diretamente com .Net")
        addToList("Como eu me vejo daqui a 5 anos?", "Daqui a 5 anos eu desejo ser especialista em desenvolvimento de Aplicativos Móveis.")
        addToList("Qual meu nível de Inglês?", "Bem, eu diria que estou no nível intermediário. Consigo ler, ouvir e me comunicar. Atualmente estou estudando na Minds School. Qualquer coisa me avisa que te indico lá para garantir um bônus para mim kkkk...")
        addToList("Meus contatos?", "Segue meu número de celular: 5592993210558.\nMeu email: dijoncavalcante@gmail.com\nPerfil do linkedIn: https://www.linkedin.com/in/dijon-braga-9a5b3911a\nO restanto consulte a Página Me Encontre. Lá você vai ter mais opções de me encontrar.")
    }

}