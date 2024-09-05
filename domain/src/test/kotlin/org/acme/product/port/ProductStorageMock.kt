package org.acme.product.port

import org.acme.product.port.dto.ProductDto
import java.util.*

//@PortMock
internal class ProductStorageMock : ProductStorage {
    private val products: MutableMap<UUID, ProductDto> = mutableMapOf()

    override fun store(dto: ProductDto): ProductDto {
        products[dto.id] = dto
        return dto
    }

    override fun findById(id: UUID): ProductDto? = products[id]

    fun findAll(): List<ProductDto> = products.values.toList()
}