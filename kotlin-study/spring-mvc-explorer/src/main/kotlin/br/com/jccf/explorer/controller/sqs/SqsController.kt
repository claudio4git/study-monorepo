package br.com.jccf.explorer.controller.sqs

import mu.KotlinLogging
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.http.HttpStatus
import org.springframework.messaging.support.MessageBuilder
import org.springframework.web.bind.annotation.*

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/sqs")
class SqsController(
    val queueMessagingTemplate: QueueMessagingTemplate
) {

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    fun send(@RequestBody messageDto: MessageDto) {
        logger.info { "Send message: $messageDto" }
        queueMessagingTemplate.send(messageDto.topicName, MessageBuilder.withPayload(messageDto.message).build())
    }
}
