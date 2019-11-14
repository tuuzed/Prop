package com.tuuzed.androidx.prop

import android.content.SharedPreferences

inline fun <reified T : Any> SharedPreferences.prop(
    key: String, defValue: T
): Lazy<Prop<T>> = lazy { SharedPreferencesProp(this, key, defValue) }
