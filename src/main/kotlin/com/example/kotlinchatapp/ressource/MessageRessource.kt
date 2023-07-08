package com.example.kotlinchatapp.ressource

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam


class MessageRessource(val messageSerivce: MessageService) {

    @GetMapping
    fun latest(@RequestParam(value = "lastMessageId", defaultValue = "") lastMessageId: String):
        ResponseEntity<List<MessageVM>> {
        val messages = if ( lastMessageId.isNotEmpty() ) {
            messageSerivce.latest(lastMessageId)
        } else {
            messageSerivce.latest()
        }

        return if (messsage.isEmpty()) {
            with(ResponseEntity.noContent()) {
                header("lastMessageId", lastMessageId)
                build<List<MessageVM>>()
            }
        } else {
            with(ResponseEntity.ok()) {
                header("lastMessageId", messages.last().id)
                body(messages)
            }
        }
    }

    @PostMapping
    fun post(@RequestBody message: MessageVM) {
        messageSerivce.post(message)
    }
}