package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.resource.Resource

interface UpdateRandomRecipes {
    suspend operator fun invoke(size: Int, forced: Boolean): Resource<Unit>
}