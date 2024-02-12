package com.ormadev.tekus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ormadev.tekus.navigation.NavManager
import com.ormadev.tekus.ui.theme.TekusTheme
import com.ormadev.tekus.viewModel.FlickrViewModel
import com.ormadev.tekus.views.ContentHomeView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : FlickrViewModel by viewModels();
        setContent {
            TekusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    ContentHomeView(viewModel)
                    NavManager(viewModel)
                }
            }
        }
    }
}
