package org.acme.product.api.dto

import org.acme.product.port.dto.ProductDto
import java.math.BigDecimal
import java.util.*

internal data class CreateProductResponse(
    val id: UUID,
    val name: String,
    val description: String,
    val price: BigDecimal
) {
    companion object {
        fun of(dto: ProductDto): CreateProductResponse =
            CreateProductResponse(
                id = dto.id,
                dto.name,
                dto.description,
                dto.price
            )
    }
}
