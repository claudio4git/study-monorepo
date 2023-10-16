package br.com.jccf.explorer.controller

import br.com.jccf.explorer.common.SpringBaseTest
import br.com.jccf.explorer.model.Book
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.hateoas.PagedResources
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import org.springframework.jdbc.core.JdbcTemplate
import java.net.URI

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookControllerTest : SpringBaseTest() {

    @Autowired
    lateinit var restTemplate: TestRestTemplate
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @BeforeAll
    internal fun beforeAll() {
    }

    @Test
    fun `create a new book`() {
        // prepare
        val book = Book("10", "Book")

        // action
        val output = restTemplate.postForEntity(URI("http://localhost:$port/book"), book, Int::class.java)

        // assertion
        Assertions.assertEquals("200 OK", output.statusCode.toString())
        Assertions.assertEquals(1, output.body)
    }

    @Test
    fun `update title book`() {
        // prepare
        jdbcTemplate.update("insert into book values (11, 'test')")
        val book = Book("11", "test changed")

        // action
        val output = restTemplate.exchange(URI("http://localhost:$port/book"),
            HttpMethod.PUT, HttpEntity(book), Int::class.java)

        // assertion
        Assertions.assertEquals("200 OK", output.statusCode.toString())
        Assertions.assertEquals(1, output.body)
    }

    @Test
    fun `retrieve book by id`() {
        // prepare
        val id = "12"
        jdbcTemplate.update("insert into book values ($id, 'test')")
        val book = Book(id, "test")

        // action
        val output = restTemplate.getForEntity("http://localhost:$port/book/$id", Book::class.java)

        // assertion
        Assertions.assertEquals("200 OK", output.statusCode.toString())
        Assertions.assertEquals(book.toString(), output.body.toString())
    }

    @Test
    fun `list all with 2 in database`() {
        // prepare
        jdbcTemplate.update("insert into book values (1, 'test 1')")
        jdbcTemplate.update("insert into book values (2, 'test 2')")

        // action
        val request = RequestEntity<Any>(HttpMethod.GET, URI("http://localhost:$port/book?page=0&size=2"))
        val refType = object : ParameterizedTypeReference<PagedResources<Book>>() {}
        val output = restTemplate.exchange<PagedResources<Book>>(request, refType)

        // assertion
        Assertions.assertEquals("200 OK", output.statusCode.toString())
        Assertions.assertEquals(2, output.body?.content?.size)
    }

    @Test
    fun `list all with 2 in database but must retrieve just one`() {
        // prepare
        jdbcTemplate.update("insert into book values (3, 'test 1')")
        jdbcTemplate.update("insert into book values (4, 'test 2')")

        // action
        val request = RequestEntity<Any>(HttpMethod.GET, URI("http://localhost:$port/book?page=0&size=1"))
        val refType = object : ParameterizedTypeReference<PagedResources<Book>>() {}
        val output = restTemplate.exchange<PagedResources<Book>>(request, refType)

        // assertion
        Assertions.assertEquals("200 OK", output.statusCode.toString())
        Assertions.assertEquals(1, output.body?.content?.size)
    }
}
