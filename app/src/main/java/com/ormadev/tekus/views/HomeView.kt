package com.ormadev.tekus.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ormadev.tekus.viewModel.FlickrViewModel

@Composable
fun HomeView(viewModel: FlickrViewModel){

    val flickrImage by viewModel.flickrResponse.collectAsState()
    LazyColumn(){
        items(flickrImage){
            item ->
            if(!item.title.equals("") && !flickrImage.isEmpty()){
                Text(text = item.title)
                Spacer(modifier = Modifier.height(20.dp))
            }

        }
    }
}