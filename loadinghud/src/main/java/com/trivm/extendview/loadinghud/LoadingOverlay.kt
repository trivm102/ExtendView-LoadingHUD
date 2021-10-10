package com.trivm.extendview.loadinghud

import android.app.Activity
import androidx.annotation.RawRes
import com.trivm.extendview.loadinghud.LoadingAnimation.BuiltinAnimations.PROGRESS_BAR
import com.trivm.extendview.loadinghud.internal.LoadingOverlayImpl
import java.util.concurrent.TimeUnit

interface LoadingOverlay {
    /** Display the loading overlay on screen. */
    fun show()

    /** Dismiss/remove the loading overlay from screen. */
    fun dismiss()

    /** Whether the loading overlay is currently showing. */
    fun isShowing(): Boolean

    companion object {

        /**
         * @param context host activity reference.
         * @param animation either one of the builtin loading animations or a custom one.
         * @param dimAmount the amount of background dim, from 0.0 for no dim to 1.0 for full dim.
         */
        fun with(
            context: Activity,
            animation: LoadingAnimation = PROGRESS_BAR,
            dimAmount: Float = 0.5f,
            isCancellable: Boolean = false,
            tintColor: String? = null
        ): LoadingOverlay = LoadingOverlayImpl(
            context,
            animation,
            dimAmount,
            isCancellable,
            tintColor
        )
    }
}

/**
 * @param dimens the width and height of the loading animation view, specified in dp.
 */
data class LoadingAnimation(
    var dimens: Int
) {

    companion object BuiltinAnimations {
        val PROGRESS_BAR = LoadingAnimation(dimens = 70)
    }
}