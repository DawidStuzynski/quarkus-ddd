package org.acme.product.model

import java.math.BigDecimal
import java.util.UUID

//@DomainObject
internal data class Product(
    val id: UUID,
    val name: String,
    val description: String,
    val price: BigDecimal
) {
    companion object {
        fun of(
            name: String,
            description: String,
            price: BigDecimal,
        ): Product =
            Product(
                id = UUID.randomUUID(),
                name = name,
                description = description,
                price = price,
            )
    }
}
