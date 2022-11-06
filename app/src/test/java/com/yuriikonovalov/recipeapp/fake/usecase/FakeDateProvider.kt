package com.yuriikonovalov.recipeapp.fake.usecase

import com.yuriikonovalov.recipeapp.data.local.DateProvider

class FakeDateProvider(private val date: String) : DateProvider {
    override fun today(): String {
        return date
    }
}