package org.example.jaxrsproductmanagement;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

@Path("/productJax")
public class ProductApp {
    static Map<Integer, Product> products = new HashMap<>();
    static {
        Product product1 = new Product("Gaming Laptop", 1499);
        Product product2 = new Product("Wireless Bluetooth Headphones", 199);
        Product product3 = new Product("Smartphone - 128GB", 899);
        Product product4 = new Product("Smartwatch", 199);
        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);
        products.put(product4.getId(), product4);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public  Map<Integer, Product> getProduct() {
        return products;
    }

}