package com.ormadev.tekus.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.ormadev.tekus.util.Constants.Companion.CUSTOM_BACKGROUND
import com.ormadev.tekus.viewModel.FlickrViewModel

@Composable
fun FlickrImageView(
    viewModel: FlickrViewModel,
    navController: NavController,
    title : String,
    imageUrl : String
){

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(CUSTOM_BACKGROUND)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "$title",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp)
            Spacer(modifier = Modifier.height(20.dp))
            FlickrFullSizeImage(image = imageUrl)
        }

    }
}

@Composable
fun FlickrFullSizeImage(image: String) {

    val flikrImage = rememberImagePainter(data = image)

    Image(
        painter = flikrImage,
        contentDescription = "Flikr Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(5.dp)
    )

}