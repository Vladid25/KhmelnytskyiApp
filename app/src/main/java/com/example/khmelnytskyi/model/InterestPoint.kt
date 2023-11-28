package com.example.khmelnytskyi.model

import com.example.khmelnytskyi.ui.PointTypes

sealed class InterestPoint(
    open val imageId:Int,
    open val name:String,
    open val description:String,
    open val type:PointTypes
)

data class Cafe(
    override val imageId: Int,
    override val name: String,
    override val description: String,
    val address : String,
    override val type: PointTypes = PointTypes.Cafe
):InterestPoint(imageId, name, description, type)

data class Restaurant(
    override val imageId: Int,
    override val name: String,
    override val description: String,
    val address: String,
    val kitchen : String,
    override val type: PointTypes = PointTypes.Restaurant
):InterestPoint(imageId, name, description, type)

data class Park(
    override val imageId: Int,
    override val description: String,
    override val name: String,
    val area:Double,
    override val type: PointTypes = PointTypes.Park
):InterestPoint(imageId, name, description, type)

