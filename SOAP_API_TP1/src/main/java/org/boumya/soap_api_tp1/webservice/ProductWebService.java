package org.boumya.soap_api_tp1.webservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.boumya.soap_api_tp1.entities.Product;
import org.boumya.soap_api_tp1.repository.ProductRepository;

import java.util.Date;
import java.util.List;

@WebService(serviceName = "ProductWS")
public class ProductWebService {
    private ProductRepository productRepository;

    @WebMethod(operationName = "sellingPrice")
    public Double sellingPrice(@WebParam(name = "price") Long id) {
        Product product = productRepository.findById(id).orElse(null);
        assert product != null;
        return product.getPrice() * 1.5;
    }

    @WebMethod(operationName = "getProduct")
    public Product getProduct(@WebParam(name = "id") Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @WebMethod(operationName = "getAllProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @WebMethod(operationName = "createProduct")
    public Product createProduct(double price, String name) {
        Product product = new Product();
        product.setPrice(price);
        product.setName(name);
        product.setDateCreation(new Date());

        productRepository.save(product);
        return product;
    }

    @WebMethod(operationName = "updateProduct")
    public Product updateProduct(Long id, Double price) {
        Product product = productRepository.findById(id).orElse(null);
        assert product != null;
        product.setPrice(price);
        return productRepository.save(product);
    }

    @WebMethod(operationName = "deleteProduct")
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
