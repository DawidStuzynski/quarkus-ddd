package org.acme.product.persistance

import jakarta.enterprise.context.ApplicationScoped
import org.acme.product.port.ProductStorage
import org.acme.product.port.dto.ProductDto
import java.math.BigDecimal
import java.util.UUID

// adapter
@ApplicationScoped
internal class ProductPostgresStorage : ProductStorage {

    override fun store(dto: ProductDto) : ProductDto{
        return dto
    }

    override fun findById(id: UUID): ProductDto? {
        return ProductDto(
            id = UUID.randomUUID(),
            name = "random",
            description = "random description",
            price = BigDecimal.valueOf(1),
        )
    }
}
