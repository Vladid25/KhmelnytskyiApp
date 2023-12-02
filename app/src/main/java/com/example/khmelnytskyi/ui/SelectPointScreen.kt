package com.example.khmelnytskyi.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.example.khmelnytskyi.database.Database.parks
import com.example.khmelnytskyi.model.InterestPoint
import com.example.khmelnytskyi.ui.theme.Typography

@Composable
fun SelectPointScreen(
    options:List<InterestPoint>,
    onPointClicked:(InterestPoint)->Unit
){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            options.forEach{
                    item ->
                PointItemRow(point = item, onPointClicked)
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PointItemRow(
    point:InterestPoint,
    onPointClicked:(InterestPoint)->Unit
){
    Card(
        onClick = {
                  onPointClicked(point)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = point.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .padding(start = 15.dp, top = 10.dp, bottom = 10.dp, end = 15.dp)
                    .clip(RoundedCornerShape(25.dp))
            )
            Text(
                text = point.name,
                textAlign = TextAlign.Center,
                fontSize = Typography.displayMedium.fontSize,
                maxLines = 1,
            )
        }
    }
}

@Preview
@Composable
fun SelectPointScreenPreview(){
    SelectPointScreen(parks, {})
}
