package me.jakub.fas.controller

import com.fasterxml.jackson.databind.ObjectMapper
import me.jakub.fas.model.request.LoanRequest
import me.jakub.fas.model.request.LoanRequestDTO
import me.jakub.fas.service.ScoringRequestService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class LoanController(
        private val objectMapper: ObjectMapper,
        private val scoringService: ScoringRequestService) {

    @PostMapping("/loan/request", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun requestLoan(@RequestBody request: LoanRequest) {
        val requestDTO = objectMapper.convertValue(request, LoanRequestDTO::class.java)
        requestDTO.requestId = UUID.randomUUID().toString()

        scoringService.scoreCustomer(requestDTO)
    }

}