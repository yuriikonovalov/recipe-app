package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.resource.Resource

/**
 * Defines a use case of saving a recipe by id.
 */
interface SaveRecipe {
    /**
     * Sets true as value of the property [com.yuriikonovalov.recipeapp.application.entities.Recipe.saved]
     * of the recipe for the given [id].
     *
     * @param id id of the recipe to be updated.
     * @return [Resource] with the id of the updated recipe.
     */
    suspend operator fun invoke(id: Int): Resource<Int>
}