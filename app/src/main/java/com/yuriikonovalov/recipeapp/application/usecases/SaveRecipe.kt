package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.resource.Resource

interface SaveRecipe {
    suspend operator fun invoke(id: Int): Resource<Int>
}