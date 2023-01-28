package com.yuriikonovalov.recipeapp.framework.data.remote.mapper

/**
 * Defines the interface for classes that are api mappers.
 */
interface MapperApi<Api, Domain> {
    fun mapToDomain(api: Api): Domain
}