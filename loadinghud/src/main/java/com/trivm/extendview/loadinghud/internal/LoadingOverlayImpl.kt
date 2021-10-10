package com.trivm.extendview.loadinghud.internal

import android.app.Activity
import com.trivm.extendview.loadinghud.LoadingAnimation
import com.trivm.extendview.loadinghud.LoadingOverlay
import java.util.concurrent.TimeUnit

internal class LoadingOverlayImpl(
    context: Activity,
    animation: LoadingAnimation,
    dimAmount: Float,
    isCancellable: Boolean,
    tintColor: String? = null
) : LoadingOverlay {

    private val overlayDialog: LoadingOverlayDialog by lazy {
        LoadingOverlayDialog(
            context,
            animation.dimens,
            dimAmount,
            isCancellable,
            tintColor
        )
    }

    override fun show() = overlayDialog.show()

    override fun dismiss() = overlayDialog.dismiss()

    override fun isShowing() = overlayDialog.isShowing
}