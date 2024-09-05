package org.acme.product.builder

import org.acme.product.usecase.dto.CreateProductInput
import java.math.BigDecimal

//@MockBuilder
internal class CreateProductInputBuilder(
    private val name: String = "name",
    private val description: String = "description",
    private val price: BigDecimal = BigDecimal.ONE,
) {
    fun build(): CreateProductInput =
        CreateProductInput(
            name = name,
            description = description,
            price = price
        )
}
