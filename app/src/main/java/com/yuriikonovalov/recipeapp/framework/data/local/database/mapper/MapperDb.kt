package com.yuriikonovalov.recipeapp.framework.data.local.database.mapper

interface MapperDb<Domain, Db> {
    fun mapToDomain(db: Db): Domain
    fun mapToDomain(dbList: List<Db>): List<Domain>
    fun mapFromDomain(domain: Domain): Db
}