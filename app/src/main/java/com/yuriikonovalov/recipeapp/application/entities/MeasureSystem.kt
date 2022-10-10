package com.yuriikonovalov.recipeapp.application.entities

sealed class MeasureSystem {
    object Metric : MeasureSystem()
    object Us : MeasureSystem()
}
