/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author admin
 */
public class CategoryDAO extends DBContext {

    public List<Category> GetAllCategory() {
        String sql = "select * from [Category]";
        List<Category> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt("category_id"), rs.getString("category_name")));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public int TotalCategory() {
        String sql = "select COUNT(*) as 'TotalCategory' from Category";
        int n = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                n = rs.getInt("TotalCategory");
            }
        } catch (Exception e) {
        }
        return n;
    }

    public String GetNameCategoryByID(int id) {
        String sql = "select category_name from Category where category_id = ?";
        String n = "";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                n = rs.getString("category_name");
            }
        } catch (Exception e) {
        }
        return n;
    }

    public int QuantityCategory(int id) {
        String sql = "select COUNT(*) as 'Quantity' from Shoes where category_id = ?";
        int n = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                n = rs.getInt("Quantity");
                return n;
            }
        } catch (Exception e) {
        }
        return n;
    }

    public void AddCategory(String name) {

        try {
            String sql = "INSERT INTO [Category]\n"
                    + "           ([category_name])\n"
                    + "     VALUES\n"
                    + "           (?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
             st.executeUpdate();
        } catch (SQLException ex) {

        }
    }
     public void DeleteCategory(int id) {
        String sql = "DELETE FROM [Category]\n" +
"      WHERE category_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception ex) {
        }
    }
}
