package br.com.jccf.springwebmvc.products

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
class Product(
    @Id
    @UuidGenerator
    var id: UUID? = UUID.randomUUID(),

    var name: String,

    var value: Double,
)
