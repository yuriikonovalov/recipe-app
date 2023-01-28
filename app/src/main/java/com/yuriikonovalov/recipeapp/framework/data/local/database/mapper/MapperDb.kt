package com.yuriikonovalov.recipeapp.framework.data.local.database.mapper

/**
 * Defines the interface for classes that are db mappers.
 */
interface MapperDb<Domain, Db> {
    fun mapToDomain(db: Db): Domain
    fun mapToDomain(dbList: List<Db>): List<Domain>
    fun mapFromDomain(domain: Domain): Db
}