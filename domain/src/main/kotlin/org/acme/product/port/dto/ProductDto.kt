package org.acme.product.port.dto

import org.acme.product.model.Product
import java.math.BigDecimal
import java.util.*

//Dto
class ProductDto(
    val id: UUID,
    val name: String,
    val description: String,
    val price: BigDecimal
) {
    internal fun toProduct(): Product =
        Product(
            id = id,
            name = name,
            description = description,
            price = price,
        )

    companion object {
        internal fun of(site: Product): ProductDto =
            ProductDto(
                id = site.id,
                name = site.name,
                description = site.description,
                price = site.price,
            )
    }
}
