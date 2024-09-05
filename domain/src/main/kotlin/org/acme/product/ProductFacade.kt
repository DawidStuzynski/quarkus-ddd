package org.acme.product

import org.acme.product.port.ProductInfoProvider
import org.acme.product.port.ProductStorage
import org.acme.product.port.dto.ProductDto
import org.acme.product.usecase.CreateProductUseCase
import org.acme.product.usecase.dto.CreateProductInput

class ProductFacade(
    private val productStorage: ProductStorage,
    private val productInfoProvider: ProductInfoProvider
) {
    fun hello(): String {
        return "hello"
    }

    fun saveProduct(input: CreateProductInput): ProductDto =
        CreateProductUseCase(
            productStorage = productStorage,
            productInfoProvider = productInfoProvider
        ).execute(input)
}
