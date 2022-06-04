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
public class Cart {
    private Shoes shoes;
    private int quantity;

    public Cart() {
    }

    public Cart(Shoes shoes, int quantity) {
        this.shoes = shoes;
        this.quantity = quantity;
    }
    
    
    

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
}
