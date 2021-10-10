package com.trivm.extendview.loadinghud.internal

import android.content.Context
import android.os.Handler
import android.util.TypedValue
import java.util.concurrent.TimeUnit


internal fun Context.dpToPixel(dimenDp: Int): Int = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    dimenDp.toFloat(),
    resources.displayMetrics
).toInt()