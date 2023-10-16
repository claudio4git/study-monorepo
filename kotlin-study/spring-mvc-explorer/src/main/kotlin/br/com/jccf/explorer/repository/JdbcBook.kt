package br.com.jccf.explorer.repository

import br.com.jccf.explorer.mapper.BookRowMapper
import br.com.jccf.explorer.model.Book
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class JdbcBook(
    private val jdbcTemplate: JdbcTemplate
) {

    fun insert(book: Book): Int =
        jdbcTemplate.update("insert into book(id, title) values(?, ?)", book.id, book.title)

    fun update(book: Book): Int =
        jdbcTemplate.update("update book set title = ? where id = ?", book.title, book.id)

    fun findOne(id: String): Book? {
        return try {
            jdbcTemplate.queryForObject("select * from book where id = ? ",
                arrayOf(id), BookRowMapper())
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }

    fun findAll(pageable: Pageable): Page<Book>? {
        return try {
            val books = jdbcTemplate.query("select * from book limit ? offset ?",
                arrayOf(pageable.pageSize, pageable.pageNumber), BookRowMapper())

            return PageImpl<Book>(books, pageable, 10)
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }
}
