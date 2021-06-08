package com.kis.mkb_test.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackBar(
    textResource: Int,
    actionTextResource: Int,
    length: Int = Snackbar.LENGTH_INDEFINITE,
    action: (View) -> Unit
    ) {
    Snackbar.make(this, resources.getString(textResource), length).setAction(resources.getString(textResource), action).show()
}

fun View.showSnackBar(
    text: String,
    actionText: String,
    length: Int = Snackbar.LENGTH_INDEFINITE,
    action: (View) -> Unit
) {
    Snackbar.make(this, text, length).setAction(actionText, action).show()
}