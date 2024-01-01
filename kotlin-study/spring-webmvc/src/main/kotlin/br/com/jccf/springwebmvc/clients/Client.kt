package br.com.jccf.springwebmvc.clients

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
class Client(
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM) // 4th version by default from Hibernate
    var id: UUID? = UUID.randomUUID(),

    @Column
    var name: String,
)
