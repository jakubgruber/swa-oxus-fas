package me.jakub.fas.model.request

import java.math.BigDecimal

data class LoanRequestDTO(

        var requestId: String? = null,
        val clientId: Int = 0,
        val loanAmount: BigDecimal = BigDecimal.ZERO,
        val callbackUrl: String? = null

)