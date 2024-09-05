package org.acme.product.api.provider

import jakarta.enterprise.context.ApplicationScoped
import org.acme.product.port.ProductInfoProvider

// adapter
@ApplicationScoped
internal class ProductInfoProviderImpl : ProductInfoProvider {
    override fun findProductInfo(productName: String): List<String> {
        return listOf("test")
    }
}