package com.example.musicapp.domain.model

data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val album: String,
    val duration: Long,
    val artUrl: String,
    val mediaUrl: String
)
