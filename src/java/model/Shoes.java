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
public class Shoes {
    /*
    create table Shoes(
	Shoes_id int primary key NOT NULL,
	Shoes_name nvarchar(50) NOT NULL,
	Shoes_price float NOT NULL,
	color_id int references Color(color_id), 
	Shoes_quantity int NOT NULL,
	Shoes_image nvarchar(50) NOT NULL,
	category_id int references Category(category_id)
)
    */
    private int id;
    private String name;
    private float price;
    private Color color;
    private int quantity;
    private String image;
    private Category category;

    public Shoes() {
    }

    public Shoes(int id, String name, float price, Color color, int quantity, String image, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
    
}
