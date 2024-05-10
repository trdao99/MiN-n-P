package com.mini_project.Service.impl;

import com.mini_project.Service.ICategoriesService;
import com.mini_project.dao.ICategoriesDao;
import com.mini_project.dao.impl.CategoriesDao;
import com.mini_project.modal.Categories;

import java.util.Collections;
import java.util.List;

public class CategoriesService implements ICategoriesService {
    public static ICategoriesDao categoriesDao = new CategoriesDao();

    @Override
    public List<Categories> getAllCategories() {
        return categoriesDao.getAllCategories();
    }

    @Override
    public Categories getCategoriesById(int id) {
        return categoriesDao.getCategoriesById(id);
    }

    @Override
    public void SaveCategory(Categories category) {
        categoriesDao.SaveCategory(category);
    }

    @Override
    public void DeleteCategory(int id) {
        categoriesDao.DeleteCategory(id);
    }
}
