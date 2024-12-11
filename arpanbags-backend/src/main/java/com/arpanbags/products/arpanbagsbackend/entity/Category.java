package com.arpanbags.products.arpanbagsbackend.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
    
    @Column(name="category_type")
	private String categoryType;
    
    @Column(name="category_name")
	private String categoryName;
    
    @OneToMany(mappedBy="category")
    private List<Products> products;
	
		

}
