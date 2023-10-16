package br.com.jccf.explorer.controller.sns

import mu.KotlinLogging
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/sns")
class SnsController(
    val notificationMessagingTemplate: NotificationMessagingTemplate
) {

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    fun send(@RequestBody notificationDto: NotificationDto) {
        logger.info { "Send notification with: $notificationDto" }
        notificationMessagingTemplate.sendNotification("jccf-sns-topic", notificationDto.message, notificationDto.subject)
    }
}
