package me.nkremlev.kafka.producer.entity

data class KafkaSendInformation(
    val topicName: String,
    val offset: Long,
    val partition: Int,
    val valueSize: Int? = null,
    val data: String
)