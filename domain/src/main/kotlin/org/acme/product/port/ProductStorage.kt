package org.acme.product.port

import org.acme.product.exception.ProductNotFoundException
import org.acme.product.port.dto.ProductDto
import java.util.*

// port
interface ProductStorage {
    fun store(dto: ProductDto): ProductDto

    fun findById(id: UUID): ProductDto?

    fun findByIdOrThrow(id: UUID): ProductDto {
        return findById(id) ?: throw ProductNotFoundException(id)
    }
}
