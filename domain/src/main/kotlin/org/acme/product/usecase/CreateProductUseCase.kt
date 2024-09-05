package org.acme.product.usecase

import io.github.oshai.kotlinlogging.withLoggingContext
import org.acme.product.model.Product
import org.acme.product.port.ProductInfoProvider
import org.acme.product.port.ProductStorage
import org.acme.product.port.dto.ProductDto
import org.acme.product.usecase.dto.CreateProductInput
import org.acme.product.usecase.operations.ProductInfoProviderOperations
import org.acme.product.usecase.operations.ProductStoreOperations
import java.util.UUID

internal class CreateProductUseCase(
    override val productStorage: ProductStorage,
    override val productInfoProvider: ProductInfoProvider
) : ProductStoreOperations,
    ProductInfoProviderOperations {
    fun execute(input: CreateProductInput): ProductDto {
        withLoggingContext(
            "name" to input.name,
        ) {
            findById(UUID.randomUUID())


            val product = Product.of(
                name = input.name,
                description = input.description,
                price = input.price,
            ).store()

            val info = fetchInfoForProduct(input.name)
            return ProductDto.of(product)
        }
    }
}
