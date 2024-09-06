package org.acme.product.service

import jakarta.enterprise.context.ApplicationScoped
import org.acme.product.persistance.ProductRepository
import org.acme.product.persistance.SuperQueryProductRepository
import org.acme.product.port.dto.ProductDto

@ApplicationScoped
internal class ProductService(
    private val productRepository: ProductRepository,
    private val superQueryProductRepository: SuperQueryProductRepository
) {
    fun readAll(): List<ProductDto> =
        productRepository.findAll().map { it.toProductDto() }

    fun readProductsWihFireworks(): String =
        superQueryProductRepository.makeQueryWithCustomParams()
}
