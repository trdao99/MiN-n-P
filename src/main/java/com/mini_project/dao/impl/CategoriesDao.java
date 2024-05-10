package com.mini_project.dao.impl;

import com.mini_project.dao.ICategoriesDao;
import com.mini_project.modal.Categories;
import com.mini_project.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoriesDao implements ICategoriesDao {


    @Override
    public List<Categories> getAllCategories() {
        Connection conn = ConnectDB.getConnection();
        List<Categories> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select*from categories  ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categories cate = new Categories();
                cate.setId(rs.getInt("id"));
                cate.setName(rs.getString("name"));

                cate.setStatus(rs.getBoolean("status"));

                list.add(cate);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public Categories getCategoriesById(int id) {
        return getAllCategories().stream().filter(cate -> cate.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void SaveCategory(Categories category) {
        Connection conn = ConnectDB.getConnection();
        PreparedStatement ps = null;
        try{
            if(category.getId() == null) {
                ps = conn.prepareStatement("insert into categories(name,status)values (?,?)");
                ps.setString(1,category.getName());
                ps.setBoolean(2,category.getStatus());
            }
            else{
                ps = conn.prepareStatement("update categories set name = ?,status = ? where id = ?");
                ps.setString(1,category.getName());
                ps.setBoolean(2,category.getStatus());
                ps.setInt(3,category.getId());
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void DeleteCategory(int id_IN) {
        Connection conn = ConnectDB.getConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("delete from categories where id = ?");
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
