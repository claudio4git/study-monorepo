package br.com.jccf.explorer.controller.sns

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class NotificationDto @JsonCreator constructor(
    @JsonProperty("subject") val subject: String,
    @JsonProperty("message") val message: String
) {
    override fun toString(): String = "subject=$subject, message=$message"
}
