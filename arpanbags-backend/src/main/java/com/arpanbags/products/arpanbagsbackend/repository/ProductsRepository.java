package com.arpanbags.products.arpanbagsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arpanbags.products.arpanbagsbackend.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

}
