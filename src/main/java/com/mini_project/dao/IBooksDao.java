package com.mini_project.dao;

import com.mini_project.dto.BooksRequest;
import com.mini_project.modal.Books;

import java.io.IOException;
import java.util.List;

public interface IBooksDao {
    List<Books> findAll();

    Books findById(Integer id);

    void save(Books book) throws IOException;

    void deleteById(Integer id);
}
