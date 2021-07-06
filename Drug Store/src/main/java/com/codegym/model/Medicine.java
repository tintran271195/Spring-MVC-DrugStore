package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String unit;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Medicine(String name, String unit, Double price) {
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public Medicine(String name, String unit, Double price, Category category) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
