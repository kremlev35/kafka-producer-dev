package me.nkremlev.kafka.producer.service.kafka

import me.nkremlev.kafka.producer.entity.KafkaSendInformation

/**
 * Сервис для отправки данных в kafka
 */
interface KafkaProducerService<K, V> {

    fun sendMessage(topicName: String, key: K?, data: V): KafkaSendInformation
}