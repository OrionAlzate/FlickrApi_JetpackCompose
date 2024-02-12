package com.ormadev.tekus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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

//                    val check : Boolean = checkConnection.CheckNetwork(this)
                    val check : Boolean = checkConnection.isNetworkAvailable(this)

                    if(check){
                        
                        NavManager(viewModel)
                    }
                    else{
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentSize(Alignment.Center),
                            horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                            Text(text = "No hay conexión a internet", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(20.dp))
                            Image(painter = painterResource(
                                id = R.drawable.baseline_signal_wifi_connected_no_internet_4_24),
                                contentDescription = "No networks connection",
                                modifier = Modifier.size(50.dp)
                            )
                        }
                    }
                }
            }
        }
    }

  
}

