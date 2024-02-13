package com.ormadev.tekus.views

import android.util.Log
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ormadev.tekus.components.FlickrCard
import com.ormadev.tekus.util.Constants.Companion.CUSTOM_BACKGROUND
import com.ormadev.tekus.viewModel.FlickrViewModel
import java.net.URLEncoder

@Composable
fun ContentHomeView(viewModel: FlickrViewModel, navController: NavController) {

    val flickrImage by viewModel.flickrResponse.collectAsState()

    LazyColumn(
        modifier = Modifier
            .background(Color(CUSTOM_BACKGROUND))

    ) {
        items(flickrImage) { item ->
            if (
                item.title != null
                && !item.title.equals("")
                && item.imageUrl != null
                && !item.imageUrl.equals("")
                ) {

                Spacer(modifier = Modifier
                    .height(5.dp))

                FlickrCard(item){
//                    Log.i("FlickrCard", "${item.title}\n working! :)")
                    val encodedimageUrl = URLEncoder.encode(item.imageUrl, "UTF-8")

                    navController.navigate("FlickrImageView/${item.title}/$encodedimageUrl")

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