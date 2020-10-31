package com.example.whatdidilearn.data

import com.example.whatdidilearn.entities.ItemLearned
import com.example.whatdidilearn.entities.Level

class DataBaseItens {
    fun getAll(): List<ItemLearned> {

    val itemOne = ItemLearned(
        "Kotlin - Null safety",
        "O sistema de tipos de Kotlin visa eliminar o perigo de referências nulas do código",
         Level.HIGH)

    val itemTwo = ItemLearned(
        "Layout editor",
        "O Design Editor exibe o layout em vários dispositivos e versões do Android.É possível criar e editar um layout usando apenas componentes visuais.",
        Level.MEDIUM)

    val itemThree = ItemLearned(
        "Git",
        "É um sistema de controle de versão distribuído. Com ele é possível rastrear mudanças no código-fonte durante o desenvolvimento de software.",
        Level.HIGH)

    val itemFour = ItemLearned(
        "GroupView",
        "É uma com.example.whatdidilearn.view especial que pode conter outras views (chamadas de filhos).É a classe base para layouts e contêineres de views.",
        Level.LOW)

    val itemFive = ItemLearned(
        "View Binding",
        "View Binding é um recurso que facilita a programação de códigos que interagem com views.",
        Level.LOW)

    return listOf(itemOne, itemTwo, itemThree, itemFour, itemFive)
    }
}