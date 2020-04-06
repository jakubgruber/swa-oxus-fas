package me.jakub.fas.service

import com.fasterxml.jackson.databind.ObjectMapper
import me.jakub.fas.model.result.OxusAppData
import me.jakub.fas.model.result.ScoringResult
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ScoringResultService(
        private val objectMapper: ObjectMapper,
        private val oxusLoanAppClient: OxusLoanAppClient
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(topics = ["\${fas.kafka.topic.scoringresult}"], containerFactory = "kafkaListenerContainerFactory")
    fun processMessage(scoringResult: ScoringResult) {
        logger.info("> processMessage - {}", scoringResult)

        val oxusAppData = objectMapper.convertValue(scoringResult, OxusAppData::class.java)

        oxusLoanAppClient.pushData(oxusAppData)
    }

}