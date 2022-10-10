package com.yuriikonovalov.recipeapp.framework.data.local.database.dao

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.framework.data.local.database.AppDatabase
import com.yuriikonovalov.recipeapp.framework.data.local.database.mapper.AggregateRecipeDbMapper
import com.yuriikonovalov.recipeapp.framework.data.local.database.mapper.IngredientDbMapper
import com.yuriikonovalov.recipeapp.fakes.recipe
import com.yuriikonovalov.recipeapp.fakes.recipes
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class RecipeDaoTest {
    private lateinit var db: AppDatabase
    private lateinit var sut: RecipeDao
    private val ingredientMapper = IngredientDbMapper()
    private val mapper = AggregateRecipeDbMapper(ingredientMapper)

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        sut = db.recipeDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertRecipe_success() = runTest {
        // BEFORE
        val expected = mapper.mapFromDomain(recipe()).recipeDb

        // WHEN
        sut.insertRecipe(expected)

        // THEN
        val actual = sut.getRecipe(expected.id)?.recipeDb
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun insertRecipes_success() = runTest {
        // BEFORE
        val expected = recipes(5, cache = true).map(mapper::mapFromDomain).map { it.recipeDb }

        // WHEN
        sut.insertRecipes(expected)

        // THEN
        val actual = sut.getCacheRecipes().first().map { it.recipeDb }
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun insertIngredients_success() = runTest {
        // BEFORE
        val expected = mapper.mapFromDomain(recipe())

        // WHEN
        sut.insertRecipe(expected.recipeDb)
        sut.insertIngredients(expected.ingredients)

        // THEN
        val actual = sut.getRecipe(expected.recipeDb.id)?.ingredients?.size
        assertThat(actual).isEqualTo(expected.ingredients.size)
    }

    @Test(expected = SQLiteConstraintException::class)
    fun insertIngredients_throwSQLiteConstraintException() = runTest {
        // BEFORE
        val expected = mapper.mapFromDomain(recipe())

        // WHEN
        // Inserting ingredient without a recipe entity will cause exception.
        sut.insertIngredients(expected.ingredients)
    }

    @Test
    fun updateRecipeSavedFlagAsTrue() = runTest {
        // BEFORE
        val expected = mapper.mapFromDomain(recipe()).recipeDb.copy(saved = false)
        sut.insertRecipe(expected)

        // WHEN
        sut.updateRecipeSavedFlag(expected.id, true)

        // THEN
        val actual = sut.getRecipe(expected.id)?.recipeDb
        assertThat(actual?.saved).isTrue()
    }

    @Test
    fun updateRecipeSavedFlagAsFalse() = runTest {
        // BEFORE
        val expected = mapper.mapFromDomain(recipe()).recipeDb.copy(saved = true)
        sut.insertRecipe(expected)

        // WHEN
        sut.updateRecipeSavedFlag(expected.id, false)

        // THEN
        val actual = sut.getRecipe(expected.id)?.recipeDb
        assertThat(actual?.saved).isFalse()
    }

    @Test
    fun delete() = runTest {
        // BEFORE
        val expected = mapper.mapFromDomain(recipe()).recipeDb
        sut.insertRecipe(expected)

        // WHEN
        sut.delete(expected.id)

        // THEN
        val actual = sut.getRecipe(expected.id)
        assertThat(actual).isNull()
    }

    @Test
    fun deleteAllCache_shouldOnlyDeleteItemsWithCacheFlagTrueAndSavedFlagFalse() = runTest {
        // BEFORE
        val expectedToBeDeleted = mapper.mapFromDomain(recipe(cache = true, saved = false)).recipeDb
        val expectedRecipes = listOf(
            recipe(cache = true, saved = true),
            recipe(cache = false, saved = false),
            recipe(cache = false, saved = true)
        ).map {
            mapper.mapFromDomain(it).recipeDb
        }
        val recipes = expectedRecipes + expectedToBeDeleted

        sut.insertRecipes(recipes)

        // WHEN
        sut.deleteAllCache()

        // THEN
        val actual = sut.getRecipe(expectedToBeDeleted.id)
        assertThat(actual).isNull()
    }

    @Test
    fun deleteNeedlessRecipes_shouldOnlyDeleteItemsWithCacheFlagFalseAndSavedFlagFalse() = runTest {
        // BEFORE
        val expectedToBeDeleted =
            mapper.mapFromDomain(recipe(cache = false, saved = false)).recipeDb
        val expectedRecipes = listOf(
            recipe(cache = true, saved = true),
            recipe(cache = true, saved = false),
            recipe(cache = false, saved = true)
        ).map {
            mapper.mapFromDomain(it).recipeDb
        }
        val recipes = expectedRecipes + expectedToBeDeleted

        sut.insertRecipes(recipes)

        // WHEN
        sut.deleteNeedlessRecipes()

        // THEN
        val actual = sut.getRecipe(expectedToBeDeleted.id)
        assertThat(actual).isNull()
    }

    @Test
    fun getCacheRecipesWhenDbContainsThose_shouldEmitNotEmptyList() = runTest {
        // BEFORE
        val recipes = listOf(
            recipe(cache = true, saved = true),
            recipe(cache = true, saved = false),
            recipe(cache = false, saved = false),
            recipe(cache = false, saved = true)
        ).map {
            mapper.mapFromDomain(it).recipeDb
        }

        sut.insertRecipes(recipes)

        // WHEN
        val actual = sut.getCacheRecipes().first().map { it.recipeDb }

        // THEN
        assertThat(actual).isNotEmpty()
        assertThat(actual.map { it.cache }).doesNotContain(false)
    }

    @Test
    fun getCacheRecipesWhenDbNotContainThose_shouldEmitEmptyList() = runTest {
        // BEFORE
        val recipes = listOf(
            recipe(cache = false, saved = true),
            recipe(cache = false, saved = false),
            recipe(cache = false, saved = false),
            recipe(cache = false, saved = true)
        ).map {
            mapper.mapFromDomain(it).recipeDb
        }
        sut.insertRecipes(recipes)

        // WHEN
        val actual = sut.getCacheRecipes().first().map { it.recipeDb }

        // THEN
        assertThat(actual).isEmpty()
    }
}