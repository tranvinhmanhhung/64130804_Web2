package hung.ntu64130804.quanlykhoahoconline.service;

import hung.ntu64130804.quanlykhoahoconline.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(int id);
    void save(Book book);
    void deleteById(int id);
}
