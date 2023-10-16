package br.com.jccf.explorer.model

import java.io.Serializable

class Book(id: String, title: String) : Serializable {

    var id: String? = id
    var title: String? = title

    override fun toString(): String = "id=$id, title=$title"
}
