package me.nkremlev.kafka.producer.api.common.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Error response")
class ErrorDtoRs (val type: String? = null,
                  val message: String?)