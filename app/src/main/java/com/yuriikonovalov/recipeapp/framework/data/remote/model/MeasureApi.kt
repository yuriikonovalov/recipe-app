package com.yuriikonovalov.recipeapp.framework.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeasureApi(
    @Json(name = "metric")
    val metric: MeasureCompoundApi? =null,
    @Json(name = "us")
    val us: MeasureCompoundApi? =null,
) {
    @JsonClass(generateAdapter = true)
    data class MeasureCompoundApi(
        @Json(name = "amount")
        val amount: Double? =null,
        @Json(name = "unitLong")
        val unitLong: String? =null,
        @Json(name = "unitShort")
        val unitShort: String? =null,
    )

}