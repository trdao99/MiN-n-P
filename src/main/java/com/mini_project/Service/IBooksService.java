package com.mini_project.Service;

import com.mini_project.dto.BooksRequest;
import com.mini_project.modal.Books;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;

public interface IBooksService {
    List<Books> findAll();

    Books findById(Integer id);

    void save(BooksRequest request) throws IOException;

    void deleteById(Integer id);
}
