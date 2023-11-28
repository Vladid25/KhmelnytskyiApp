package com.example.khmelnytskyi.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.khmelnytskyi.database.Database.types
import com.example.khmelnytskyi.model.PointType
import com.example.khmelnytskyi.ui.theme.Typography

enum class PointTypes{
    Cafe,
    Restaurant,
    Park
}

@Composable
fun TypePointScreen(
    options:List<PointType>,
    onTypeClicked: (PointTypes) -> Unit
){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            options.forEach {
                    item ->
                TypeItemRow(typePoint = item, onTypeClicked)
            }
        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypeItemRow(
    typePoint: PointType,
    onTypeClicked:(PointTypes) -> Unit,
){
    Card(
        onClick = {
            onTypeClicked(typePoint.types)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card {
                Image(
                    painter = painterResource(id = typePoint.imageId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(start = 15.dp, top = 10.dp, bottom = 10.dp, end = 15.dp)
                        .clip(RoundedCornerShape(25.dp))
                )
            }
            Text(
                text = typePoint.types.name,
                textAlign = TextAlign.Center,
                fontSize = Typography.displayMedium.fontSize,
                maxLines = 1,
            )
        }
    }
}

@Preview
@Composable
fun TypePointScreenPreview(){
    //(options = types)
}