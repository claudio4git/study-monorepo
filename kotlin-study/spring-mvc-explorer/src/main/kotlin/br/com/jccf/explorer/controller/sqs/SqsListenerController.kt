package br.com.jccf.explorer.controller.sqs

import mu.KotlinLogging
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class SqsListenerController {

    @SqsListener("spring-book-kotlin-sqs", deletionPolicy = SqsMessageDeletionPolicy.ALWAYS)
    fun receiveMessage(message: String, @Header("SenderId") senderId: String) {
        logger.info { "Received message: $message from senderId: $senderId" }
    }
}
