package com.ormadev.tekus.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ormadev.tekus.components.FlickrImage
import com.ormadev.tekus.util.Constants.Companion.CUSTOM_BACKGROUND
import com.ormadev.tekus.viewModel.FlickrViewModel

@Composable
fun FlickrImageView(
    viewModel: FlickrViewModel,
    navController: NavController,
    title : String,
    imageUrl : String
){

    val flickrImage by viewModel.flickrResponse.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(CUSTOM_BACKGROUND))
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "$title")
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "$imageUrl", modifier = Modifier
            .fillMaxWidth()
            .align(CenterHorizontally
            )
        )

//        FlickrImage(image = imageUrl)
    }
}