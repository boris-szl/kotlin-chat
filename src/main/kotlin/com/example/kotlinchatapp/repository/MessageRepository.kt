package com.example.kotlinchatapp.repository

import com.example.kotlinchatapp.domainmodel.Message
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface MessageRepository : CrudRepository<Message, String>{

    fun findLatest(): List<Message>
    fun findLatest(@Param("id") id: String): List<Message>
}