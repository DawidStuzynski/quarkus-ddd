package org.acme.product.usecase.operations

import org.acme.product.model.Product
import org.acme.product.port.ProductStorage
import org.acme.product.port.dto.ProductDto
import java.util.*

internal interface ProductStoreOperations {
    val productStorage: ProductStorage

    fun Product.store() =
        productStorage.store(dto = ProductDto.of(this))
            .toProduct()

    fun findById(id: UUID): Product? =
        productStorage
            .findById(id)
            ?.toProduct()


    fun findProductByIdOrThrow(id: UUID): Product =
        productStorage
            .findByIdOrThrow(id)
            .toProduct()
}
