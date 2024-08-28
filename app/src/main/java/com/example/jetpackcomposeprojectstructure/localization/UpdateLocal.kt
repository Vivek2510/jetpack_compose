package com.example.jetpackcomposeprojectstructure.localization

import android.content.Context
import java.util.Locale

fun updateLocale(context: Context, locale: Locale) {
    val config = context.resources.configuration
    Locale.setDefault(locale)
    config.setLocale(locale)
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
}