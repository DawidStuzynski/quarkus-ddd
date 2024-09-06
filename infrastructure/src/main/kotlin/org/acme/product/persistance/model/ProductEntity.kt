package org.acme.product.persistance.model

import org.acme.product.port.dto.ProductDto
import java.math.BigDecimal
import java.time.Instant
import java.util.*

//@Entity
internal class ProductEntity(
//    @Id
    val id: UUID,
    val name: String,
    val description: String,
    val price: BigDecimal,
) {
    fun toProductDto(): ProductDto =
        ProductDto(
            id = id,
            name = name,
            description = description,
            price = price,
        )

    companion object {
        fun of(dto: ProductDto): ProductEntity =
            ProductEntity(
                id = dto.id,
                name = dto.name,
                description = dto.description,
                price = dto.price,
            )
    }
}
