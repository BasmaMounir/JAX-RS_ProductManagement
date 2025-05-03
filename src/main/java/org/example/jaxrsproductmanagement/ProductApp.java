package org.example.jaxrsproductmanagement;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(@Valid Product product){
        product = new Product(product.getName(), product.getPrice());
        Product createdProduct = products.put(product.getId(), product);
        return Response.ok(createdProduct).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@Valid Product product,@PathParam("id") int id){
        Product existingProduct = products.get(id);
        if(existingProduct == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
        }

        return Response.ok(existingProduct).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@QueryParam("id") int id){
        Product existingProduct = products.get(id);

        if(existingProduct == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        products.remove(id);
        return Response.ok("{\"message\": \"Product deleted successfully\"}").build();
    }

}