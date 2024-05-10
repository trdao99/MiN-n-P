package com.mini_project.dao.impl;

import com.mini_project.Service.impl.CategoriesService;
import com.mini_project.dao.IBooksDao;
import com.mini_project.modal.Books;
import com.mini_project.util.ConnectDB;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class BooksDao implements IBooksDao {
    public static CategoriesService categoriesService = new CategoriesService();
    @Override
    public List<Books> findAll() {
        Connection conn = ConnectDB.getConnection();
        List<Books> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select*from books  ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setStock(rs.getInt("stock"));
                book.setAuthor(rs.getString("author"));
                book.setTotalPages(rs.getInt("totalPages"));
                book.setYearCreated(rs.getInt("yearCreated"));
                book.setStatus(rs.getBoolean("status"));
                book.setCategory(categoriesService.getCategoriesById(rs.getInt("categoryID")));
                list.add(book);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }
    @Override
    public Books findById(Integer id) {
        return null;
    }
    @Override
    public void save(Books book) throws IOException {
        Connection conn = ConnectDB.getConnection();
        CallableStatement call = null;
        try {
            if (book.getId()==null){
                call = conn.prepareCall("insert into books(name,price,stock,totalPages,yearCreated,author,status,categoryId) values (?,?,?,?,?,?,?,?)");
            } else {
                call = conn.prepareCall("update books set name=?,price=?,stock=?,totalPages=?,yearCreated=?,author=?,status=?,categoryId=? where id=?");
                call.setInt(9,book.getId());
            }
            call.setString(1,book.getName());
            call.setDouble(2,book.getPrice());
            call.setInt(3,book.getStock());
            call.setInt(4,book.getTotalPages());
            call.setInt(5,book.getYearCreated());
            call.setString(6,book.getAuthor());
            call.setBoolean(7,book.isStatus());
            call.setInt(8,book.getCategory().getId());
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id_IN) {
        Connection conn = ConnectDB.getConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("delete from books where id = ?");
            ps.setInt(1, id_IN);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectDB.closeConnection(conn);
        }
    }
}
