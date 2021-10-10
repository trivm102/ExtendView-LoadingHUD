package com.trivm.extendview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.trivm.extendview.loadinghud.LoadingAnimation
import com.trivm.extendview.loadinghud.LoadingOverlay

class MainActivity : AppCompatActivity() {
    private val loadingOverlay: LoadingOverlay by lazy {
        LoadingOverlay.with(
            context = this,
            animation = LoadingAnimation.PROGRESS_BAR,
            tintColor = "#FFFF5722"
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txt: TextView = findViewById(R.id.hello)
        txt.setOnClickListener {
            loadingOverlay.show()
        }
    }
}