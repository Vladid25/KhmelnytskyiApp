package com.example.khmelnytskyi.database

import com.example.khmelnytskyi.R
import com.example.khmelnytskyi.model.Cafe
import com.example.khmelnytskyi.model.Park
import com.example.khmelnytskyi.model.PointType
import com.example.khmelnytskyi.model.Restaurant
import com.example.khmelnytskyi.ui.PointTypes

object Database {
    val parks = listOf(
        Park(
            name = "Шевченка",
            description = "Відомий парк",
            imageId = R.drawable.shevchenko,
            area = 90.4
        ),
        Park(
            name = "Франка",
            description = "супер",
            imageId = R.drawable.park_franka,
            area = 89.34
        )
    )

    val cafes = listOf(
        Cafe(
            imageId = R.drawable.lyumor,
            name = "Lumor",
            description = "asdf",
            address = "asdfasd"
        )
    )

    val restaurants = listOf(
        Restaurant(
            imageId = R.drawable.rest_franko,
            name = "Franko",
            description = "asdfa",
            kitchen = "Chinese",
            address = "asdfa"
        )
    )

    val types = listOf(
        PointType(
            types = PointTypes.Cafe,
            imageId =R.drawable.lyumor
        ),
        PointType(
            types = PointTypes.Park,
            imageId =R.drawable.park1
        ),
        PointType(
            types = PointTypes.Restaurant,
            imageId =R.drawable.unnamed
        )
    )
}

