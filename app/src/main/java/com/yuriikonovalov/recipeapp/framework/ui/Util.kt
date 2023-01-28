package com.yuriikonovalov.recipeapp.framework.ui

import com.yuriikonovalov.recipeapp.R

/**
 * Returns drawable resource id based on the value of the receiver.
 * @receiver [Boolean] value.
 * @return [Int] - resource id.
 */
fun Boolean.asSavedIconRes(): Int {
    return if (this) R.drawable.ic_bookmark else R.drawable.ic_bookmark_border
}

/**
 * Returns string resource id based on the value of the receiver.
 * @receiver [Boolean] value.
 * @return [Int] - resource id.
 */
fun Boolean.asSavedStringRes(): Int {
    return if (this) R.string.saved else R.string.save
}