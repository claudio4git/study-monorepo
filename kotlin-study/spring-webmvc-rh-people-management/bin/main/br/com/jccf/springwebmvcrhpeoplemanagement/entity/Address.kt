package br.com.jccf.springwebmvcrhpeoplemanagement.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "address")
open class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    open var id: UUID? = UUID.randomUUID()

    @OneToOne(mappedBy = "address")
    open var people: People? = null

    @Column(name = "type", nullable = false)
    open var type: AddressType? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null
}
