package com.ormadev.tekus.views

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ormadev.tekus.components.FlickrCard
import com.ormadev.tekus.viewModel.FlickrViewModel

@Composable
fun HomeView(viewModel: FlickrViewModel) {

    val flickrImage by viewModel.flickrResponse.collectAsState()
    LazyColumn() {
        items(flickrImage) { item ->
            if (
                item.title != null
                && !item.title.equals("")
                && item.imageUrl != null
                && !item.imageUrl.equals("")
                ) {
                FlickrCard(item){
                    Log.i("FlickrCard", "${item.title}\n working! :)")
                }
                Text(text = item.title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()

                    )
                Spacer(modifier = Modifier
                    .padding(10.dp)
                    .height(20.dp))
            }

        }
    }
}