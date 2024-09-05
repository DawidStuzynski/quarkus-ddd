package org.acme.product

import jakarta.enterprise.context.ApplicationScoped
import org.acme.product.port.ProductInfoProvider
import org.acme.product.port.ProductStorage

internal class ProductFacadeConfig {
    @ApplicationScoped
    fun productFacade(
        productStorage: ProductStorage,
        productInfoProvider: ProductInfoProvider
    ): ProductFacade = ProductFacade(
        productStorage = productStorage,
        productInfoProvider = productInfoProvider
    )
}
