package org.example.jaxrsproductmanagement;

public class Product {
    private static int counter = 1;

    private int id;
    private String name;
    private int price;

    public Product() {
    }

    public Product(String name, int price) {
        this.id =  counter++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

