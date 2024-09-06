package org.acme.product.persistance

import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
internal class SuperQueryProductRepository {
    fun makeQueryWithCustomParams(): String {
        println("making super complex query using pure jdbc to get super complicated view and soo much joins")
        return "result of complex query"
    }
}