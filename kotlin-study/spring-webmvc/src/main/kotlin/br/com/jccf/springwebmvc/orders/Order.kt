package br.com.jccf.springwebmvc.orders

import br.com.jccf.springwebmvc.products.Product
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
class Order(
    @Id
    @UuidGenerator
    var id: UUID? = UUID.randomUUID(),

    @Column(name = "created_at")
    val createdAt: LocalDateTime,

    @Column(nullable = true)
    @OneToMany(cascade = [CascadeType.ALL])
    val products: List<Product>? = emptyList()
)
