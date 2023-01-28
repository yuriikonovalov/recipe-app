package com.yuriikonovalov.recipeapp.presentation

/**
 * An interface of a mapper between domain and ui models.
 */
interface MapperUi<Domain, Ui> {
    fun mapToUi(domain: Domain): Ui
}