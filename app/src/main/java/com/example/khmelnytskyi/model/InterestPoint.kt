package com.example.khmelnytskyi.model

sealed class InterestPoint(
    open val imageId:Int,
    open val name:String,
    open val description:String
)

data class Cafe(
    override val imageId: Int,
    override val name: String,
    override val description: String,
    val address : String
):InterestPoint(imageId, name, description)

data class Restaurant(
    override val imageId: Int,
    override val name: String,
    override val description: String,
    val address: String,
    val kitchen : String
):InterestPoint(imageId, name, description)

data class Park(
    override val imageId: Int,
    override val description: String,
    override val name: String,
    val area:Double
):InterestPoint(imageId, name, description)

