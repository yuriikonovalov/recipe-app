package com.yuriikonovalov.recipeapp.framework.ui

import com.yuriikonovalov.recipeapp.R

fun Boolean.asSavedIconRes(): Int {
    return if (this) R.drawable.ic_bookmark else R.drawable.ic_bookmark_border
}

fun Boolean.asSavedStringRes(): Int {
    return if (this) R.string.saved else R.string.save
}