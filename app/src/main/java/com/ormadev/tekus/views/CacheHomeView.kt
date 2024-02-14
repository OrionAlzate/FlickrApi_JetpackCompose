package com.ormadev.tekus.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ormadev.tekus.components.PersistenceCard
import com.ormadev.tekus.util.Constants
import com.ormadev.tekus.viewModel.FlickrViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CacheHomeView(viewModel: FlickrViewModel){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Flickr API",
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(Constants.CUSTOM_BACKGROUND)
                )
            )
        }
    ){
        ContentCacheHomeView(viewModel, it)
    }
}

@Composable
fun ContentCacheHomeView(viewModel: FlickrViewModel, pad: PaddingValues) {
    val persistenceList by viewModel.persistenceEntityList.collectAsState()
    LazyColumn(
        modifier = Modifier
            .background(Color(Constants.CUSTOM_BACKGROUND))
            .padding(pad)

    ) {
        items(persistenceList) { item ->
            if (
                item.title != null
                && !item.title.equals("")
                && item.imageUrl != null
                && !item.imageUrl.equals("")
            ) {

                Spacer(modifier = Modifier
                    .height(5.dp))

                PersistenceCard(item){
//                    Log.i("PersistenceCard", "${item.title}\n working! :)")
                }
                Text(
                    text = item.title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier
                    .height(20.dp))
            }
        }
    }
}