package com.yuriikonovalov.recipeapp.presentation

interface MapperUi<Domain, Ui> {
    fun mapToUi(domain: Domain): Ui
}