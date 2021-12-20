package me.nkremlev.kafka.producer.api.common.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Информация об отправленном сообщении в Kafka")
data class KafkaSendDtoRs(
    @field:Schema(description = "Название топика в который было отправленно сообщение")
    val topicName: String,
    @field:Schema(description = "Номер сообщения в kafka")
    val offset: Long,
    @field:Schema(description = "Номер партиции в топике")
    val partition: Int,
    @field:Schema(description = "Размер отправленного сообщения")
    val valueSize: Int? = null,
    @field:Schema(description = "Значение сообщения")
    val data: String
)