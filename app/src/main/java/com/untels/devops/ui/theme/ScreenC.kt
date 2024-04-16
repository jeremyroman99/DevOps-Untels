package com.untels.devops.ui.theme

import android.view.LayoutInflater
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.untels.devops.R

@Composable
fun ScreenC() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.main_activity, null)
            view
        }
    )
}
@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    ScreenC()
}
