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
import java.util.Map;
import model.Cart;
import model.Order;
import model.Profit;

/**
 *
 * @author admin
 */
public class OrderDAO extends DBContext {
     public int CreateOrderAndReturnId(Order order) {
        try {
            
            String sql = "INSERT INTO [Order]\n" +
"           ([fullname]\n" +
"           ,[account_id]\n" +
"           ,[phone_number]\n" +
"           ,[address]\n" +
"           ,[note]\n" +
"           ,[status]\n" +
"           ,[total_money]\n" +
"           ,[Date]\n" +
"           ,[email])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,GETDATE()\n" +
"           ,?)";
            PreparedStatement st = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1,order.getFullname());
            st.setInt(2, 0);
            st.setString(3,order.getPhone_number());
            st.setString(4, order.getAddress());
            st.setString(5, order.getNote());
            st.setString(6, order.getStatus());
            st.setFloat(7, order.getTotal_money());
            st.setString(8, order.getEmail());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }
    
    public void SaveOrderDetail(int orderid, Map<Integer, Cart> carts) {
        try {
            String sql = "INSERT INTO [Order_Details]\n" +
"           ([order_id]\n" +
"           ,[product_id]\n" +
"           ,[price]\n" +
"           ,[num]\n" +
"           ,[total_number])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";
            /*PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                Integer productId = entry.getKey();
                Cart cart = entry.getValue();
                ps.setString(2, cart.getSkin().getSkinName());
                ps.setString(3, cart.getSkin().getSkinImg());
                ps.setDouble(4, cart.getSkin().getSkinPrice());
                ps.setInt(5, cart.getQuantity());
                ps.executeUpdate();
            }*/
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, orderid);    
            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                Integer shoesId = entry.getKey();
                Cart cart = entry.getValue();
                ps.setInt(2, cart.getShoes().getId());
                ps.setFloat(3, cart.getShoes().getPrice());
                ps.setInt(4, cart.getQuantity());
                ps.setFloat(5, cart.getQuantity()*cart.getShoes().getPrice());
                ps.executeUpdate();
            }
        } catch (Exception e) {
        }
    }
     public List<Order> GetAllOrder() {
        String sql = "select * from [Order]";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                 Order order = new Order(rs.getInt("id"), rs.getString("fullname"), rs.getInt("account_id"), rs.getString("email"), rs.getString("phone_number"), rs.getString("address"), rs.getString("note"), rs.getString("status"), rs.getFloat("total_money"), rs.getDate("Date"));
                 list.add(order);
            }
        } catch (SQLException e) {
        }
        return list;
    }
     public int TotalOrderProfit() {
        String sql = "select SUM(total_money) as 'total' from [Order]";
        int n = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                n = rs.getInt("total");
                return n;
            }
        } catch (Exception e) {
        }
        return n;
    }
     public List<Profit> GetProfitWeek() {
        String sql = "select top 7 SUM(o.total_money) as 'total', SUM(od.num) 'num',o.date from order_details od\n" +
"join [order] o \n" +
"on od.id = o.id\n" +
"group by o.date\n" +
"order by o.date asc";
        List<Profit> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Profit profit = new Profit(rs.getFloat("total"), rs.getInt("num"), rs.getDate("date"));
                 list.add(profit);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public static void main(String[] args) {
        OrderDAO orderdao = new  OrderDAO();
        
        orderdao.SaveOrderDetail(1, null);
      
    }
}
