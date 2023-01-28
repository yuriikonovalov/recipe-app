package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.resource.Resource

/**
 * Defines a use case of unsaving a recipe by id.
 */
interface UnsaveRecipe {
    /**
     * Sets false as value of the property [com.yuriikonovalov.recipeapp.application.entities.Recipe.saved]
     * of the recipe for the given [id].
     *
     * @param id id of the recipe to be updated.
     * @return [Resource] with the id of the updated recipe.
     */
    suspend operator fun invoke(id: Int): Resource<Unit>
}