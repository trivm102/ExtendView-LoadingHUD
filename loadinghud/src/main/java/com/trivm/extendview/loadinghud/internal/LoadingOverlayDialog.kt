package com.trivm.extendview.loadinghud.internal

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ProgressBar

internal class LoadingOverlayDialog(
    context: Activity,
    dimensDp: Int,
    dimAmount: Float,
    isCancellable: Boolean,
    tintColor: String? = null
) : Dialog(context) {

    init {
        setBackground(dimAmount)
        setCancelable(isCancellable)
        setContentView(
            context,
            dimensDp,
            tintColor
        )
    }

    private fun setBackground(dimAmount: Float) {
        window?.apply {
            setBackgroundDrawableResource(android.R.color.transparent)
            addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            setDimAmount(dimAmount)
        }
    }

    private fun setContentView(
        context: Context,
        dimensDp: Int,
        tintColor: String?
    ) {
        val rootView = FrameLayout(context).apply {
            val dimenPxs = context.dpToPixel(dimensDp)
            val progressBar = ProgressBar(context)
            tintColor?.let { color ->
                progressBar.indeterminateTintList = ColorStateList.valueOf(Color.parseColor(color))
            }
            addView(progressBar, dimenPxs, dimenPxs)
        }
        setContentView(rootView)
    }
}