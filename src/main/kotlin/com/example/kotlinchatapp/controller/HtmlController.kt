package com.example.kotlinchatapp.controller

import org.springframework.web.bind.annotation.GetMapping

class HtmlController(val messageService: MessageService) {

    @GetMapping("/")
    fun index(model: Model): String {
        val messages = messageService.latest()

        model["messages"] = messages
        model["lastMessageId"] = messages.lastOrNull()?.id ?: "" // safe call operator, elvis operator
        return "chat"
    }
}