package com.example.kotlinchatapp.model

data class MessageVM(
        val content: String,
        val user: UserVM,
        val sent: Instant,
        val id: String? = null
)
