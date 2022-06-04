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
import model.Account;

/**
 *
 * @author admin
 */
public class AdminDAO extends DBContext {
    public Account check(String user, String pass) {
        String sql = "select * from Account where account_email = ? and account_password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("account_id"), rs.getString("account_email"), rs.getString("account_password"), rs.getString("account_name"), rs.getString("account_phone"), rs.getString("account_address"), rs.getBoolean("account_role"));
                return acc;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Account> GetAllAccount() {
        String sql = "SELECT * FROM Account";
        List<Account> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("account_id"), rs.getString("account_name"), rs.getString("account_password"), rs.getString("account_email"), rs.getString("account_phone"), rs.getString("account_address"), rs.getBoolean("account_role"));
                list.add(acc);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void DeleteAccount(int id) {
        String sql = "DELETE FROM [Account]"
                + "      WHERE account_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception ex) {
        }
    }
     public int TotalAccount() {
        String sql = "select COUNT(*) as 'Quantity' from Account";
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
       public Account GetAccountById(int id) {
        String sql = "select * from Account where account_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("account_id"), rs.getString("account_email"), rs.getString("account_password"), rs.getString("account_name"), rs.getString("account_phone"), rs.getString("account_address"), rs.getBoolean("account_role"));
                return acc;
            }
        } catch (Exception e) {
        }
        return null;
    }
       public void AddAccount(Account acc) {

        try {
            String sql = "INSERT INTO [Users]\n" +
"           ([users_id]\n" +
"           ,[users_name]\n" +
"           ,[users_password]\n" +
"           ,[users_email]\n" +
"           ,[users_phone]\n" +
"           ,[users_address]\n" +
"           ,[users_role])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, 41);
            st.setString(1, acc.getName());
            st.setString(2, acc.getPassword());
            st.setString(3, acc.getEmail());
            st.setString(4, acc.getPhone());
            st.setString(5, acc.getAddress());
            st.setBoolean(6, false);         
             st.executeUpdate();
        } catch (SQLException ex) {

        }
    }
        public void UpdateAccount(Account acc) {

        try {
            String sql = "UPDATE [Account]\n" +
"   SET [account_email] = ?\n" +
"      ,[account_password] = ?\n" +
"      ,[account_name] = ?\n" +
"      ,[account_phone] = ?\n" +
"      ,[account_address] = ?\n" +
" WHERE account_id =  ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, acc.getEmail());
            st.setString(2, acc.getPassword());
            st.setString(3, acc.getName());
            st.setString(4, acc.getPhone());
            st.setString(5, acc.getAddress());
            st.setInt(6, acc.getId());         
             st.executeUpdate();
        } catch (SQLException ex) {

        }
    }
    
}
