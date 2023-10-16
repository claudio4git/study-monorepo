package br.com.jccf.explorer.config.aws

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider
import com.amazonaws.services.sns.AmazonSNS
import com.amazonaws.services.sns.AmazonSNSClientBuilder
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AwsSnsConf {

    @Bean
    fun amazonSNS(): AmazonSNS = AmazonSNSClientBuilder.standard().withCredentials(EnvironmentVariableCredentialsProvider()).build()

    @Bean
    fun notificationMessagingTemplate(amazonSNS: AmazonSNS) = NotificationMessagingTemplate(amazonSNS)
}
