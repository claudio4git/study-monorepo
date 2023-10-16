package br.com.jccf.explorer.controller.sqs

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class MessageDto @JsonCreator constructor(
    @JsonProperty("topicName") val topicName: String,
    @JsonProperty("message") val message: String
) {
    override fun toString(): String = "topicName=$topicName, message=$message"
}
