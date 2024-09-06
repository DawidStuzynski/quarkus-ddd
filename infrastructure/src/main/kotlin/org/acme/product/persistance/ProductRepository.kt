package org.acme.product.persistance

import jakarta.enterprise.context.ApplicationScoped
import org.acme.product.persistance.model.ProductEntity
import java.math.BigDecimal
import java.util.*

@ApplicationScoped
internal class ProductRepository {
    fun save(entity: ProductEntity) {
        println("saved in postgres")
    }

    fun findAll(): List<ProductEntity> = listOf(
        ProductEntity(
            id = UUID.randomUUID(),
            name = "name",
            description = "description",
            price = BigDecimal.valueOf(100.0),
        )
    )
}
