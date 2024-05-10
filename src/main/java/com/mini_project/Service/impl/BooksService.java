package com.mini_project.Service.impl;

import com.mini_project.Service.IBooksService;
import com.mini_project.dao.IBooksDao;
import com.mini_project.dao.ICategoriesDao;
import com.mini_project.dao.impl.BooksDao;
import com.mini_project.dao.impl.CategoriesDao;
import com.mini_project.dto.BooksRequest;
import com.mini_project.modal.Books;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class BooksService implements IBooksService {
    public static ICategoriesDao categoriesDao = new CategoriesDao();
    public static IBooksDao booksDao = new BooksDao();

    @Override
    public List<Books> findAll() {
        return booksDao.findAll();
    }

    @Override
    public Books findById(Integer id) {
        return booksDao.findById(id);
    }

    @Override
    public void save(BooksRequest request) throws IOException {
        Books modalBook = new Books(request.getId(), request.getName(), request.getPrice(), request.getStock(), request.getAuthor(), request.getTotalPages(), request.getYearCreated(), request.isStatus(), null);
        Integer id = request.getCategoryID();
        modalBook.setCategory(categoriesDao.getCategoriesById(id));
        booksDao.save(modalBook);
    }

    @Override
    public void deleteById(Integer id) {
        booksDao.deleteById(id);
    }
}
