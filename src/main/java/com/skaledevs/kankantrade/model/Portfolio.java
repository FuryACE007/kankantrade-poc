package com.skaledevs.kankantrade.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;  // Only store user ID

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public Portfolio() {
    }

    public Portfolio(Long userId, Stock stock, Integer quantity) {
        this.userId = userId;
        this.stock = stock;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(id, portfolio.id) && Objects.equals(userId, portfolio.userId) && Objects.equals(stock, portfolio.stock) && Objects.equals(quantity, portfolio.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, stock, quantity);
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + id +
                ", userId=" + userId +
                ", stock=" + stock +
                ", quantity=" + quantity +
                '}';
    }
}
