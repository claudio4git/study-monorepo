package br.com.jccf.explorer.controller.sns

import mu.KotlinLogging
import org.springframework.cloud.aws.messaging.endpoint.NotificationStatus
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationMessageMapping
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationSubscriptionMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("sns/subscribe")
class SnsSubscribeController {

    @NotificationSubscriptionMapping
    fun subscribe(notificationStatus: NotificationStatus) = notificationStatus.confirmSubscription()

    @NotificationMessageMapping
    fun receiveNotification(message: String, subject: String) {
        logger.info { "Received message: $message with subject: $subject" }
    }
}
