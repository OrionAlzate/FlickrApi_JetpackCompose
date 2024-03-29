package com.ormadev.tekus.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.ormadev.tekus.R
import com.ormadev.tekus.model.PhotoItemResponse

@Composable
fun FlickrCard(
    photoItemResponse: PhotoItemResponse,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .padding(10.dp)
            .shadow(40.dp)
            .clickable { onClick() }
    ) {
        Column {
            FlickrImage(image = photoItemResponse.imageUrl)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FlickrImage(image: String) {

    val flikrImage = rememberImagePainter(
        data = image,
        builder = {
            crossfade(true)
            placeholder(R.drawable.baseline_broken_image_24)
        }

    )

    Image(
        painter = flikrImage,
        contentDescription = "Flikr Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )



}