package com.quickearn.app

data class Task(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val reward: Double = 0.0,
    val type: String = "survey" // Puede ser "encuesta", "video", "clic"
)
