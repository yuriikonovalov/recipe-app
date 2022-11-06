package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.resource.Resource

interface UnsaveRecipe {
    suspend operator fun invoke(id: Int): Resource<Unit>
}