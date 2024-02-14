package com.ormadev.tekus.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.ormadev.tekus.R
import com.ormadev.tekus.persistence.PersistenceEntity

@Composable
fun PersistenceCard(
    persistenceEntity: PersistenceEntity,
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
            PersistenceImage(image = persistenceEntity.imageUrl)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PersistenceImage(image : String) {

    val flikrImage = rememberImagePainter(data = image)

//    Image(
//        painter = flikrImage,
////        painter = painterResource(
////            id = R.drawable.baseline_broken_image_24),
//        contentDescription = "Flikr Image",
//        contentScale = ContentScale.Crop,
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(250.dp)
//    )

    GlideImage(
        model = flikrImage.imageLoader,
        contentDescription = "Flickr Image",
        loading = placeholder(R.drawable.baseline_broken_image_24),
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ){
        it.thumbnail()
    }



}