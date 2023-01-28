package com.yuriikonovalov.recipeapp.framework.data.local

import android.icu.text.DateFormat
import com.yuriikonovalov.recipeapp.data.local.DateProvider
import java.time.Instant
import java.util.*
import javax.inject.Inject


class DateProviderImpl @Inject constructor() : DateProvider {
    override fun today(): String {
        return DateFormat.getDateInstance().format(
            Date.from(Instant.now())
        )
    }
}