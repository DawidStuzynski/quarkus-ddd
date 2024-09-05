package org.acme.product.usecase.dto

import java.math.BigDecimal

data class CreateProductInput(
    val name: String,
    val description: String,
    val price: BigDecimal
)
