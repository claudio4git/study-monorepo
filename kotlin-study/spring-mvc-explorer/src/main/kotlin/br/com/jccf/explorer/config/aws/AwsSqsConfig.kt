package br.com.jccf.explorer.config.aws

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.cloud.aws.messaging.listener.QueueMessageHandler
import org.springframework.cloud.aws.messaging.listener.SimpleMessageListenerContainer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor


@Configuration
class AwsSqsConfig {

    @Bean
    fun amazonSQSAsync(): AmazonSQSAsync = AmazonSQSAsyncClientBuilder.standard()
        .withCredentials(EnvironmentVariableCredentialsProvider())
        .withEndpointConfiguration(AwsClientBuilder.EndpointConfiguration("https://sqs.us-east-1.amazonaws.com/119514570535/spring-book-kotlin-sqs", "us-east-1"))
        .build()

    @Bean
    fun simpleMessageListenerContainer(amazonSQSAsync: AmazonSQSAsync, queueMessageHandler: QueueMessageHandler): SimpleMessageListenerContainer {
        val simpleMessageListenerContainer = SimpleMessageListenerContainer()
        simpleMessageListenerContainer.setAmazonSqs(amazonSQSAsync)
        simpleMessageListenerContainer.setMessageHandler(queueMessageHandler)
        simpleMessageListenerContainer.setMaxNumberOfMessages(10)
        simpleMessageListenerContainer.setTaskExecutor(threadPoolTaskExecutor())
        return simpleMessageListenerContainer
    }

    @Bean
    fun queueMessageHandler(amazonSQSAsync: AmazonSQSAsync): QueueMessageHandler {
        val queueMessageHandlerFactory = QueueMessageHandlerFactory()
        queueMessageHandlerFactory.setAmazonSqs(amazonSQSAsync)
        return queueMessageHandlerFactory.createQueueMessageHandler()
    }

    @Bean
    fun queueMessagingTemplate(amazonSQSAsync: AmazonSQSAsync) = QueueMessagingTemplate(amazonSQSAsync)

    private fun threadPoolTaskExecutor(): ThreadPoolTaskExecutor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 10
        executor.maxPoolSize = 10
        executor.initialize()
        return executor
    }
}
