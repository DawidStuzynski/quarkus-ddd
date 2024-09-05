package org.acme.product.usecase

import org.acme.product.CreateProductFacadeBaseTest
import org.acme.product.builder.CreateProductInputBuilder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreateProductSpec : CreateProductFacadeBaseTest() {

    @Test
    fun `should save product`() {
        val input = CreateProductInputBuilder(name = "different name").build()
        facade.saveProduct(input)
        val product = productStorage.findAll().single()

        assertThat(product.description).isEqualTo(input.description)
    }
}