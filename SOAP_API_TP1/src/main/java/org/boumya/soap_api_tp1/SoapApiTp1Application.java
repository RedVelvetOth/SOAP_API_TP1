package org.boumya.soap_api_tp1;

import org.boumya.soap_api_tp1.entities.Product;
import org.boumya.soap_api_tp1.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SoapApiTp1Application {

    public static void main(String[] args) {
        SpringApplication.run(SoapApiTp1Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Stream.of("Table", "Closet", "Chair").forEach(name -> {
                Product product = productRepository.save(new Product(null, name, 90.5, new Date(124, Calendar.OCTOBER, 15)));
                productRepository.save(product);
            });
        };
    }

}
