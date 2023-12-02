package com.example.khmelnytskyi.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.khmelnytskyi.database.Database
import com.example.khmelnytskyi.model.Cafe
import com.example.khmelnytskyi.model.Park
import com.example.khmelnytskyi.model.Restaurant

@Composable
fun DisplayPark(
    park: Park
){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = park.imageId),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text ="Парк " + park.name,
                fontSize = MaterialTheme.typography.displayMedium.fontSize,
                fontStyle = MaterialTheme.typography.displayMedium.fontStyle,
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 10.dp)
            )
            Text(
                text ="Площа: " + park.area.toString(),
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                modifier = Modifier.padding(start = 10.dp)
            )
            Text(
                text = park.description,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}

@Composable
fun DisplayCafe(
    cafe: Cafe
){

}

@Composable
fun DisplayRestaurant(
    restaurant: Restaurant
){

}
@Preview
@Composable
fun ParkPreview(){
    DisplayPark(park = Database.parks[0])
}