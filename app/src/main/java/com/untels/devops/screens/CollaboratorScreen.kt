package com.untels.devops.screens

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import com.untels.devops.R

@Composable
fun CollaboratorScreen() {
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