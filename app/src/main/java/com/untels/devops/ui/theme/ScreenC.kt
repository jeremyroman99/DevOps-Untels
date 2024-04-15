package com.untels.devops.ui.theme

import android.view.LayoutInflater
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.untels.devops.R

@Composable
fun ScreenC() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            // Inflar la vista desde el archivo XML
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.main_activity, null)

            // Retornar la vista inflada
            view
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    ScreenC()
}
