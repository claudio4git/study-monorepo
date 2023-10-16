package br.com.jccf.springwebmvcrhpeoplemanagement.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "skill")
open class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    open var id: UUID? = UUID.randomUUID()

    @Column(nullable = false)
    open var name: String? = null
}
