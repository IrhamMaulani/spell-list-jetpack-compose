package com.example.jetpackcomposedemo.domain.model

data class Cat(
    val id: String,
    val name: String,
    val image: String,
    val origin : String,
    val temperament : String
)

val catList: List<Cat> = listOf(
    Cat(
        "1",
        "Kucing Oren",
        "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg",
        origin = "Egypt",
        temperament = "Active, Energetic, Independent, Intelligent, Gentle"
    ),
    Cat(
        id = "2",
        name = "Kathie",
        image = "https://cdn2.thecatapi.com/images/ozEvzdVM-.jpg",
        origin = "Leann",
        temperament = "Affectionate, Social, Intelligent, Playful, Active"
    ),
    Cat(
        id = "3",
        name = "American Bobtail",
        image = "https://cdn2.thecatapi.com/images/hBXicehMA.jpg",
        origin = "UK",
        temperament = "Intelligent, Interactive, Lively, Playful, Sensitive"
    )
)
