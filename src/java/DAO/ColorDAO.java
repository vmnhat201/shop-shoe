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

import model.Color;

/**
 *
 * @author admin
 */
public class ColorDAO extends DBContext{
    public List<Color> GetAllColor() {
        String sql = "select * from [Color]";
        List<Color> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Color c = new Color(rs.getInt("color_id"), rs.getString("color_name"));
                list.add(c);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public String GetNameColorByID(int id) {
        String sql = "select color_name from Color where color_id = ?";
        String n = "";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                n = rs.getString("color_name");
            }
        } catch (SQLException e) {
        }
        return n;
    }
}
