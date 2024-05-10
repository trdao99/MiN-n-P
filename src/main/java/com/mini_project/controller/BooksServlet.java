package com.mini_project.controller;

import com.mini_project.Service.IBooksService;
import com.mini_project.Service.ICategoriesService;
import com.mini_project.Service.impl.BooksService;
import com.mini_project.Service.impl.CategoriesService;
import com.mini_project.dto.BooksRequest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BooksServlet", value = "/BooksServlet")
public class BooksServlet extends HttpServlet {
    private static final IBooksService booksService = new BooksService();
    private static final ICategoriesService categoriesService = new CategoriesService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "LIST":
                    request.setAttribute("list", booksService.findAll());
                    request.getRequestDispatcher("/view/books/listBooks.jsp").forward(request, response);
                    break;
                case "ADD":
                    request.setAttribute("categories", categoriesService.getAllCategories());
                    request.getRequestDispatcher("/view/books/SaveBook.jsp").forward(request, response);
                    break;
                case "EDIT":
                    Integer id1 = Integer.parseInt(request.getParameter("id"));
                    String name1 = request.getParameter("name");
                    Double price1 = Double.valueOf(request.getParameter("price"));
                    Integer stock1 = Integer.valueOf(request.getParameter("stock"));
                    String author1 = request.getParameter("author");
                    Integer totalPages1 = Integer.valueOf(request.getParameter("totalPages"));
                    Integer yearCreated1 = Integer.valueOf(request.getParameter("yearCreated"));
                    String category = request.getParameter("categoryID");
                    Boolean status1 = Boolean.valueOf(request.getParameter("status"));
                    request.setAttribute("name1", name1);
                    request.setAttribute("price1", price1);
                    request.setAttribute("stock1", stock1);
                    request.setAttribute("author1", author1);
                    request.setAttribute("totalPages1", totalPages1);
                    request.setAttribute("yearCreated1", yearCreated1);
                    request.setAttribute("status1", status1);
                    request.setAttribute("id1", id1);
                    request.setAttribute("categories", categoriesService.getAllCategories());
                    request.setAttribute("category", category);
                    request.getRequestDispatcher("/view/books/editBook.jsp").forward(request, response);
                    break;
                case "DEL":
                    Integer id = Integer.parseInt(request.getParameter("id"));
                    booksService.deleteById(id);
                    request.setAttribute("list", booksService.findAll());
                    request.getRequestDispatcher("/view/books/listBooks.jsp").forward(request, response);
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
                    // Retrieve form parameter values for adding a book
                    String name = request.getParameter("name");
                    Double price = Double.valueOf(request.getParameter("price"));
                    Integer stock = Integer.valueOf(request.getParameter("stock"));
                    String author = request.getParameter("author");
                    Integer totalPages = Integer.valueOf(request.getParameter("totalPages"));
                    Integer yearCreated = Integer.valueOf(request.getParameter("yearCreated"));
                    Integer category = Integer.valueOf(request.getParameter("category"));
                    Boolean status = Boolean.valueOf(request.getParameter("status"));
                    // Create a new BooksRequest object and save it
                    BooksRequest books = new BooksRequest(null, name, price, stock, author, totalPages, yearCreated, status, category);
                    booksService.save(books);
                    // Redirect to the servlet with the action set to "LIST"
                    response.sendRedirect("/BooksServlet?action=LIST");
                    break;
                case "UPDATE":
                    // Retrieve form parameter values for updating a book
                    Integer id1 = Integer.parseInt(request.getParameter("id"));
                    String name1 = request.getParameter("name");
                    Double price1 = Double.valueOf(request.getParameter("price"));
                    Integer stock1 = Integer.valueOf(request.getParameter("stock"));
                    String author1 = request.getParameter("author");
                    Integer totalPages1 = Integer.valueOf(request.getParameter("totalPages"));
                    Integer yearCreated1 = Integer.valueOf(request.getParameter("yearCreated"));
                    Integer categoryID1 = Integer.valueOf(request.getParameter("category"));
                    Boolean status1 = Boolean.valueOf(request.getParameter("status"));
                    // Create a new BooksRequest object and save it
                    BooksRequest book1 = new BooksRequest(id1, name1, price1, stock1, author1, totalPages1, yearCreated1, status1, categoryID1);
                    booksService.save(book1);
                    // Redirect to the servlet with the action set to "LIST"
                    response.sendRedirect("/BooksServlet?action=LIST");
                    break;
            }
        }
    }
}
