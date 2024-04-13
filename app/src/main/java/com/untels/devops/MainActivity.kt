package com.untels.devops

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.untels.devops.navigation.AppNavigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        setTheme(R.style.Theme_DevOpsUntels)
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.main_activity)
        setContent {
            AppNavigation()
        }
    }
    fun openLinkedIn1(view: View?) {
        // Aquí define la URL de LinkedIn que quieres abrir
        val url = "https://www.linkedin.com/in/jeremyroman99/"

        // Crea un intent implícito para abrir el navegador con la URL especificada
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(url))
        startActivity(intent)
    }
    fun openLinkedIn2(view: View?) {
        // Aquí define la URL de LinkedIn que quieres abrir
        val url = "https://www.linkedin.com/in/carloscosme99/"

        // Crea un intent implícito para abrir el navegador con la URL especificada
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(url))
        startActivity(intent)
    }
    fun openyoutube1(view: View?) {
        // Aquí define la URL de LinkedIn que quieres abrir
        val url = "https://www.youtube.com/watch?v=xvFZjo5PgG0"

        // Crea un intent implícito para abrir el navegador con la URL especificada
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(url))
        startActivity(intent)
    }
    fun openyoutube2(view: View?) {
        // Aquí define la URL de LinkedIn que quieres abrir
        val url = "https://www.youtube.com/watch?v=xvFZjo5PgG0"

        // Crea un intent implícito para abrir el navegador con la URL especificada
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(url))
        startActivity(intent)
    }
    fun openinstagram1(view: View?) {
        // Aquí define la URL de LinkedIn que quieres abrir
        val url = "https://www.instagram.com/jeremy.roman99/"

        // Crea un intent implícito para abrir el navegador con la URL especificada
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(url))
        startActivity(intent)
    }
    fun openinstagram2(view: View?) {
        // Aquí define la URL de LinkedIn que quieres abrir
        val url = "https://www.instagram.com/carlosc.0199/"

        // Crea un intent implícito para abrir el navegador con la URL especificada
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(url))
        startActivity(intent)
    }
}


