package me.nkremlev.kafka.producer.api.common

import me.nkremlev.kafka.producer.KafkaProducerApplication

const val PRIMARY_JSON_PATH = "/fns_primary_1.json"
const val INCREMENT_JSON_PATH = "/increment_1.json"

val JSON_FOLDER_PATH: String = KafkaProducerApplication::class.java.getResource("/json")!!.path