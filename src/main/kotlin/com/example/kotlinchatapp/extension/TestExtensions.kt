package com.example.kotlinchatapp.extension

import com.example.kotlinchatapp.domainmodel.Message
import com.example.kotlinchatapp.viewmodel.MessageVM
import java.time.temporal.ChronoUnit.MILLIS

fun MessageVM.prepareForTesting() = copy(id = null, sent = sent.truncatedTo(MILLIS))

fun Message.prepareForTesting() = copy(id = null, sent = sent.truncatedTo(MILLIS))