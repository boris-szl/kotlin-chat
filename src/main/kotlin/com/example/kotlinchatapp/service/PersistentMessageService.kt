package com.example.kotlinchatapp.service


import com.example.kotlinchatapp.extension.asDomainObject
import com.example.kotlinchatapp.extension.mapToViewModel
import com.example.kotlinchatapp.repository.MessageRepository
import com.example.kotlinchatapp.viewmodel.MessageVM
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Service
@Primary
class PersistentMessageService(val messageRepository : MessageRepository) : MessageService {

    override fun latest(): List<MessageVM> =
            messageRepository.findLatest()
                    .mapToViewModel()

    override fun after(lastMessageId: String): List<MessageVM> =
            messageRepository.findLatest(lastMessageId)
                    .mapToViewModel()

    override fun post(message: MessageVM) {
        messageRepository.save(message.asDomainObject())
    }

}