package org.acme.product

import org.acme.product.port.ProductInfoProvider
import org.acme.product.port.ProductStorage
import org.acme.product.port.dto.ProductDto
import org.acme.product.usecase.CreateProductUseCase
import org.acme.product.usecase.dto.CreateProductInput

//@Facade
class ProductFacade(
    private val productStorage: ProductStorage,
    private val productInfoProvider: ProductInfoProvider
) {
    fun saveProduct(input: CreateProductInput): ProductDto =
        CreateProductUseCase(
            productStorage = productStorage,
            productInfoProvider = productInfoProvider
        ).execute(input)
}
