package com.yuriikonovalov.recipeapp.framework.data.remote.mapper

interface MapperApi<Api, Domain> {
    fun mapToDomain(api: Api): Domain
}