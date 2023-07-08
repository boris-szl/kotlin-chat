package com.example.kotlinchatapp.viewmodel

import java.time.Instant

data class MessageVM(
        val content: String,
        val user: UserVM,
        val sent: Instant,
        val id: String? = null
)
