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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Color;
import model.Shoes;

/**
 *
 * @author admin
 */
public class ShoesDAO extends DBContext {

    public List<Shoes> GetAllShoes() {
        String sql = "SELECT s.Shoes_id,s.Shoes_name,s.Shoes_price,s.color_id,c.color_name, s.Shoes_quantity,s.Shoes_image,s.category_id,ca.category_name FROM Shoes s \n"
                + "inner join Category ca on (s.category_id=ca.category_id)\n"
                + "inner join Color c on (s.color_id = c.color_id)";
        List<Shoes> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("color_name"));
                Shoes shoes = new Shoes(rs.getInt("Shoes_id"), rs.getString("Shoes_name"), rs.getFloat("Shoes_price"), color, rs.getInt("Shoes_quantity"), rs.getString("Shoes_image"), c);
                list.add(shoes);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Shoes> SearchShoesByName(String key) {
        String sql = "SELECT s.Shoes_id,s.Shoes_name,s.Shoes_price,s.color_id,cl.color_name,s.Shoes_quantity,s.Shoes_image,c.category_id,c.category_name FROM Shoes s inner join Category c on (s.category_id = c.category_id)\n"
                + "  inner join Color cl on (cl.color_id = s.color_id) where S.Shoes_name Like ?";
        List<Shoes> list = new ArrayList<>();
        try {

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + key + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("color_name"));
                Shoes shoes = new Shoes(rs.getInt("Shoes_id"), rs.getString("Shoes_name"), rs.getFloat("Shoes_price"), color, rs.getInt("Shoes_quantity"), rs.getString("Shoes_image"), c);
                list.add(shoes);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Shoes> Top10ShoesAsc() {
        String sql = "SELECT TOP 10 s.Shoes_id,s.Shoes_name,s.Shoes_price,s.color_id,cl.color_name,s.Shoes_quantity,s.Shoes_image,c.category_id,c.category_name FROM Shoes s inner join Category c on (s.category_id=c.category_id)\n"
                + "  inner join Color cl on (s.color_id = cl.color_id)\n"
                + "  ORDER BY Shoes_price asc";
        List<Shoes> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("color_name"));
                Shoes shoes = new Shoes(rs.getInt("Shoes_id"), rs.getString("Shoes_name"), rs.getFloat("Shoes_price"), color, rs.getInt("Shoes_quantity"), rs.getString("Shoes_image"), c);
                list.add(shoes);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public List<Shoes> Top10ShoesDesc() {
        String sql = "SELECT TOP 10 s.Shoes_id,s.Shoes_name,s.Shoes_price,s.color_id,cl.color_name,s.Shoes_quantity,s.Shoes_image,c.category_id,c.category_name FROM Shoes s inner join Category c on (s.category_id=c.category_id)\n"
                + "  inner join Color cl on (s.color_id = cl.color_id)\n"
                + "  ORDER BY Shoes_price desc";
        List<Shoes> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("color_name"));
                Shoes shoes = new Shoes(rs.getInt("Shoes_id"), rs.getString("Shoes_name"), rs.getFloat("Shoes_price"), color, rs.getInt("Shoes_quantity"), rs.getString("Shoes_image"), c);
                list.add(shoes);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Shoes GetShoesById(int id) {
        String sql = "SELECT s.Shoes_id,s.Shoes_name,s.Shoes_price,s.color_id,c.color_name, s.Shoes_quantity,s.Shoes_image,s.category_id,ca.category_name FROM Shoes s \n"
                + "inner join Category ca on (s.category_id=ca.category_id)\n"
                + "inner join Color c on (s.color_id = c.color_id) where Shoes_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("color_name"));
                Shoes shoes = new Shoes(rs.getInt("Shoes_id"), rs.getString("Shoes_name"), rs.getFloat("Shoes_price"), color, rs.getInt("Shoes_quantity"), rs.getString("Shoes_image"), c);
                return shoes;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public int TotalShoes() {
        String sql = "select COUNT(*) as 'Quantity' from Shoes ";
        int n = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                n = rs.getInt("Quantity");
                return n;
            }
        } catch (Exception e) {
        }
        return n;
    }
    public void DeleteShoes(int id) {
        String sql = "DELETE FROM [Shoes]"
                + "      WHERE shoes_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception ex) {
        }
    }

    public List<Shoes> Tab(int cid) {
        String sql = "select s.Shoes_id,s.Shoes_name,s.Shoes_price,s.color_id,cl.color_name,s.Shoes_quantity,s.Shoes_image,c.category_id,c.category_name from Shoes s \n"
                + "inner join Category c on (s.category_id=c.category_id) \n"
                + "inner join Color cl on (cl.color_id=s.color_id)\n"
                + "where s.category_id = ?";
        List<Shoes> list = new ArrayList<>();
        try {

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("color_name"));
                Shoes shoes = new Shoes(rs.getInt("Shoes_id"), rs.getString("Shoes_name"), rs.getFloat("Shoes_price"), color, rs.getInt("Shoes_quantity"), rs.getString("Shoes_image"), c);
                list.add(shoes);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Shoes> getListByPage(List<Shoes> list,
            int start, int end) {
        ArrayList<Shoes> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public void update(Shoes p) {
        try {
            //Update Product set product_name = ?, product_price = ? , product_quanlity = ? , product_image = ?, category_id = ? where product_id = ?
            String sql = "UPDATE [Shoes]\n"
                    + "   SET [Shoes_name] = ?\n"
                    + "      ,[Shoes_price] = ?\n"
                    + "      ,[color_id] = ?\n"
                    + "      ,[Shoes_quantity] = ?\n"
                    + "      ,[Shoes_image] = ?\n"
                    + "      ,[category_id] = ?\n"
                    + " WHERE Shoes_id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setFloat(2, p.getPrice());
            st.setInt(3, p.getColor().getId());
            st.setInt(4, p.getQuantity());
            st.setString(5, p.getImage());
            st.setInt(6, p.getCategory().getId());
            st.setInt(7, p.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ShoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AddShoes(Shoes s) {

        try {
            String sql = "insert into [Shoes] values(?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getName());
            st.setFloat(2, s.getPrice());
            st.setInt(3, s.getColor().getId());
            st.setInt(4, s.getQuantity());
            st.setString(5, s.getImage());
            st.setInt(6, s.getCategory().getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ShoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Shoes> GetShoesByColor(int color_id) {
        String sql = "select s.Shoes_id,s.Shoes_name,s.Shoes_price,s.color_id,cl.color_name,s.Shoes_quantity,s.Shoes_image,c.category_id,c.category_name from Shoes s inner join Category c on (s.category_id = c.category_id)\n"
                + "inner join Color cl on (cl.color_id = s.color_id)\n"
                + "where s.color_id = ?";
        List<Shoes> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, color_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("color_name"));
                Shoes shoes = new Shoes(rs.getInt("Shoes_id"), rs.getString("Shoes_name"), rs.getFloat("Shoes_price"), color, rs.getInt("Shoes_quantity"), rs.getString("Shoes_image"), c);
                list.add(shoes);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Shoes> PriceAsc() {
        String sql = "select s.Shoes_id,s.Shoes_name,s.Shoes_price,s.color_id,cl.color_name,s.Shoes_quantity,s.Shoes_image,c.category_id,c.category_name from Shoes s inner join Category c on (s.category_id = c.category_id)\n"
                + "inner join Color cl on (cl.color_id = s.color_id)\n"
                + "order by s.Shoes_price asc";
        List<Shoes> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("color_name"));
                Shoes shoes = new Shoes(rs.getInt("Shoes_id"), rs.getString("Shoes_name"), rs.getFloat("Shoes_price"), color, rs.getInt("Shoes_quantity"), rs.getString("Shoes_image"), c);
                list.add(shoes);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Shoes> PriceDesc() {
        String sql = "select s.Shoes_id,s.Shoes_name,s.Shoes_price,s.color_id,cl.color_name,s.Shoes_quantity,s.Shoes_image,c.category_id,c.category_name from Shoes s inner join Category c on (s.category_id = c.category_id)\n"
                + "inner join Color cl on (cl.color_id = s.color_id)\n"
                + "order by s.Shoes_price desc";
        List<Shoes> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("color_name"));
                Shoes shoes = new Shoes(rs.getInt("Shoes_id"), rs.getString("Shoes_name"), rs.getFloat("Shoes_price"), color, rs.getInt("Shoes_quantity"), rs.getString("Shoes_image"), c);
                list.add(shoes);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Shoes> NameAsc() {
        String sql = "select s.Shoes_id,s.Shoes_name,s.Shoes_price,s.color_id,cl.color_name,s.Shoes_quantity,s.Shoes_image,c.category_id,c.category_name from Shoes s inner join Category c on (s.category_id = c.category_id)\n"
                + "inner join Color cl on (cl.color_id = s.color_id)\n"
                + "order by s.Shoes_name asc";
        List<Shoes> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("color_name"));
                Shoes shoes = new Shoes(rs.getInt("Shoes_id"), rs.getString("Shoes_name"), rs.getFloat("Shoes_price"), color, rs.getInt("Shoes_quantity"), rs.getString("Shoes_image"), c);
                list.add(shoes);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Shoes> NameDesc() {
        String sql = "select s.Shoes_id,s.Shoes_name,s.Shoes_price,s.color_id,cl.color_name,s.Shoes_quantity,s.Shoes_image,c.category_id,c.category_name from Shoes s inner join Category c on (s.category_id = c.category_id)\n"
                + "inner join Color cl on (cl.color_id = s.color_id)\n"
                + "order by s.Shoes_name desc";
        List<Shoes> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("color_name"));
                Shoes shoes = new Shoes(rs.getInt("Shoes_id"), rs.getString("Shoes_name"), rs.getFloat("Shoes_price"), color, rs.getInt("Shoes_quantity"), rs.getString("Shoes_image"), c);
                list.add(shoes);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public static void main(String[] args) {
        ShoesDAO shoesdao = new ShoesDAO();
        List<Shoes> shoeslist = shoesdao.SearchShoesByName("Nike");

        System.out.println(shoeslist.get(0).getName());
    }

}
