package org.acme.product

import org.acme.product.port.ProductStorageMock
import org.acme.product.port.ProductInfoProviderMock
import org.junit.jupiter.api.BeforeEach

internal abstract class CreateProductFacadeBaseTest {
    protected lateinit var productInfoProvider: ProductInfoProviderMock
    protected lateinit var productStorage: ProductStorageMock
    protected lateinit var facade: ProductFacade

    @BeforeEach
    fun reset() {
        productInfoProvider = ProductInfoProviderMock()
        productStorage = ProductStorageMock()

        facade = ProductFacade(
            productInfoProvider = productInfoProvider,
            productStorage = productStorage
        )
    }
}
