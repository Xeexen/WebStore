package com.practice2.practice2.core.domain.product.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "product")
@XmlType(propOrder = {
        "name",
        "unitPrice",
        "description",
        "category",
        "unitsInStock",
        "condition"
})
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private double unitPrice;

    @Column(columnDefinition="TEXT")
    private String description;

    private String manufacturer;

    private String category;

    private Long unitsInStock;

    private Long unitsInOrder;

    @ColumnDefault("false")
    private boolean discontinued;

    private String condition;

    @Nullable
    private String image;

    public Product() {
    }

    public Product(String name, double unitPrice, String description, String manufacturer, String category, Long unitsInStock, Long unitsInOrder, boolean discontinued, String condition, String image) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.description = description;
        this.manufacturer = manufacturer;
        this.category = category;
        this.unitsInStock = unitsInStock;
        this.unitsInOrder = unitsInOrder;
        this.discontinued = discontinued;
        this.condition = condition;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Long getUnitsInOrder() {
        return unitsInOrder;
    }

    public void setUnitsInOrder(Long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", category='" + category + '\'' +
                ", unitsInStock=" + unitsInStock +
                ", unitsInOrder=" + unitsInOrder +
                ", discontinued=" + discontinued +
                ", condition='" + condition + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
