package org.acme.product.api.dto

import java.math.BigDecimal

internal data class CreateProductRequest(
    val name: String,
    val description: String,
    val price: BigDecimal
)
