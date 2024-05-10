package com.mini_project.dao;

import com.mini_project.modal.Categories;

import java.util.List;

public interface ICategoriesDao {
    List<Categories> getAllCategories();

    Categories getCategoriesById(int id);

    void SaveCategory(Categories category);

    void DeleteCategory(int id);
}
