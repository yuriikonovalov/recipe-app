package com.yuriikonovalov.recipeapp.application.usecases

import com.yuriikonovalov.recipeapp.resource.Resource

/**
 * Defines a use case of updating random recipes.
 */
interface UpdateRandomRecipes {
    /**
     * Loads a number([size]) of new random recipes and saves them to database.
     *
     * @param size a number of recipes to be updated.
     * @param forced if true - comparing of the latest date of caching will be skipped,
     * so updating may happen multiple times per day.
     *
     * @return [Resource.Success] if updating is successful. [Resource.Failure] if updating is unsuccessful.
     */
    suspend operator fun invoke(size: Int, forced: Boolean): Resource<Unit>
}