package br.com.jccf.explorer.mapper

import br.com.jccf.explorer.model.Book
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class BookRowMapper : RowMapper<Book> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Book? {
        return Book(rs.getString("id"), rs.getString("title"));
    }
}
