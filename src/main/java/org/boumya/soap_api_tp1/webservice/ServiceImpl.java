package org.boumya.soap_api_tp1.webservice;

import org.boumya.soap_api_tp1.entities.Product;

import java.util.List;

public interface ServiceImpl {

    Double sellingPrice(Long id);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    Product createProduct(double price, String name);
    Product updateProduct(Long id, Double price);
    void deleteProduct(Long id);
}
