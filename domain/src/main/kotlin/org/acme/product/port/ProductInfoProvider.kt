package org.acme.product.port

// port
interface ProductInfoProvider {
    fun findProductInfo(productName: String): List<String>
}
