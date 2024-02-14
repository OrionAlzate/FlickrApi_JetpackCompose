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

@Composable
fun PersistenceImage(image: String) {

    val flikrImage = rememberImagePainter(data = image)

    Image(
        painter = flikrImage,
        contentDescription = "Flikr Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )

}