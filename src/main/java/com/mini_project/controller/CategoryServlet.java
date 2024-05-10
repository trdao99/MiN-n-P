package com.mini_project.controller;

import com.mini_project.Service.ICategoriesService;
import com.mini_project.Service.impl.CategoriesService;
import com.mini_project.modal.Categories;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "CategoryServlet", value = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    private static final ICategoriesService categoriesService = new CategoriesService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "LIST":
                    request.setAttribute("list", categoriesService.getAllCategories());
                    request.getRequestDispatcher("/view/categories/listCate.jsp").forward(request, response);
                    break;
                case "ADD":
                    request.getRequestDispatcher("/view/categories/SaveCate.jsp").forward(request, response);
                    break;
                case "EDIT":
                    Integer id1 = Integer.parseInt(request.getParameter("id"));
                    String name1 = request.getParameter("name");
                    Boolean status1 = Boolean.valueOf(request.getParameter("status"));
                    request.setAttribute("name1", name1);
                    request.setAttribute("status1", status1);
                    request.setAttribute("id1", id1);
                    request.getRequestDispatcher("/view/categories/edit.jsp").forward(request, response);
                    break;
                case "DEL":
                    Integer id = Integer.parseInt(request.getParameter("id"));
                    categoriesService.DeleteCategory(id);
                    request.setAttribute("list", categoriesService.getAllCategories());
                    request.getRequestDispatcher("/view/categories/listCate.jsp").forward(request, response);
                    break;
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "ADD":
                    String name = request.getParameter("name");
                    String status = request.getParameter("status");
                    Categories categories = new Categories(null, name, Boolean.valueOf(status));
                    categoriesService.SaveCategory(categories);
                    response.sendRedirect("/CategoryServlet?action=LIST");
                    break;
                case "UPDATE":
                    String name1 = request.getParameter("name");
                    String status1 = request.getParameter("status");
                    Integer id1 = Integer.parseInt(request.getParameter("id"));
                    Categories categories1 = new Categories(id1, name1, Boolean.valueOf(status1));
                    categoriesService.SaveCategory(categories1);
                    response.sendRedirect("/CategoryServlet?action=LIST");
                    break;
            }
        }
    }
}