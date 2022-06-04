/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class Account {
    /*
    Create table Account(
	account_id int primary key NOT NULL,
	account_email nvarchar(50) NOT NULL,
	account_password nvarchar(30) NOT NULL,
	account_name nvarchar(30) NOT NULL,
	account_phone nvarchar(10) not null,
	account_address nvarchar(100) not null,
	account_role bit,
)
    )
    */
    private int id;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private boolean role;

    public Account() {
    }

    public Account(int id, String email, String password, String name, String phone, String address, boolean role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    
    
}
