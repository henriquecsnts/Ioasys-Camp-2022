package com.example.myapplication.domain.model

data class Book(
    val id: String,
    val name: String,
    val author: String = "Tim Brown",
    val pages: String = "150 páginas",
    val editor: String = "Editora Loyola",
    val date: String = "Publicado em 2020",
    val language: String = "Inglês",
    val originName: String = "Change By Design",
    val isbn10: String = "0062856626",
    val isbn13: String = "978-0062856623",
    val review: String = "Lorem ipsum dolor sit amet. Non suscipit ullam et eveniet voluptatem est repellendus incidunt est tempore magni aut quaerat esse a temporibus laborum? Qui internos maiores et animi adipisci in perspiciatis accusantium.",
    val imageUrl: String = ""
)
