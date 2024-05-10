package com.mini_project.Service;

import com.mini_project.modal.Categories;

import java.util.List;

public interface ICategoriesService {
    List<Categories> getAllCategories();

    Categories getCategoriesById(int id);

    void SaveCategory(Categories category);

    void DeleteCategory(int id);
}
