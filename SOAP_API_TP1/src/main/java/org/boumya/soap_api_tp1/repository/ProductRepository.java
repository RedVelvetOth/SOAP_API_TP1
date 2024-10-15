package org.boumya.soap_api_tp1.repository;

import org.boumya.soap_api_tp1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
