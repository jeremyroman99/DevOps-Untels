package com.untels.devops.screens

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView



@Composable
fun ResourceScreen() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            // Inflar la vista desde el archivo XML
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(com.untels.devops.R.layout.recursos, null)

            // Retornar la vista inflada
            view
        }
    )
}