package com.ormadev.tekus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.ormadev.tekus.checkConnection.CheckConnection
import com.ormadev.tekus.navigation.NavManager
import com.ormadev.tekus.ui.theme.TekusTheme
import com.ormadev.tekus.viewModel.FlickrViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : FlickrViewModel by viewModels();
        setContent {
            TekusTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var checkConnection = CheckConnection()

                    val check : Boolean = checkConnection.CheckNetwork(this)
                    
                    if(check){
                        
                        NavManager(viewModel)
                    }
                    else{
                        Column(
                            modifier = Modifier
                                .fillMaxSize()

                            ) {

                        }
                        Text(text = "No hay conexión a internet")
                    }
                }
            }
        }
    }

  
}

