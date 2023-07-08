package com.example.kotlinchatapp.extension

import com.example.kotlinchatapp.domainmodel.ContentType
import com.example.kotlinchatapp.domainmodel.Message
import com.example.kotlinchatapp.viewmodel.MessageVM
import com.example.kotlinchatapp.viewmodel.UserVM
import java.net.URL

fun MessageVM.asDomainObject(contentType: ContentType = ContentType.PLAIN): Message = Message(
        content,
        contentType,
        sent,
        user.name,
        user.avatarImageLink.toString(),
        id
)

fun Message.asViewModel(): MessageVM = MessageVM(
        content,
        UserVM(username, URL(userAvatarImageLink)),
        sent,
        id
)

fun List<Message>.mapToViewModel(): List<MessageVM> = map { it.asViewModel() }

fun ContentType.render(content: String): String = when (this) {
    ContentType.PLAIN -> content
}