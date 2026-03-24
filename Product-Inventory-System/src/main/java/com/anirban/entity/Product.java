package com.anirban.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String category;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private Double price;
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	LocalDateTime createdAt;
	@Column(nullable = false)
	LocalDateTime updatedAt;
	
	public Product() {
		super();
	}

	public Product(Long id, String name, String category, Integer quantity, Double price, String status,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", quantity=" + quantity + ", price="
				+ price + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt=LocalDateTime.now();
		this.updatedAt=LocalDateTime.now();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=LocalDateTime.now();
	}
	
}
