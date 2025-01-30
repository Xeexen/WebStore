package com.practice2.practice2.core.domain.product.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.ColumnDefault;

@JacksonXmlRootElement(localName = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank(message = "Field Product could not be null")
    @JacksonXmlProperty
    private String name;
    @NotBlank(message = "Field Unit Price could not be null")
    @JacksonXmlProperty
    private double unitPrice;
    @NotBlank(message = "Field Description could not be null")
    @JacksonXmlProperty
    private String description;
    @NotBlank(message = "Field Manufacturer could not be null")
    @JacksonXmlProperty
    private String manufacturer;
    @NotBlank(message = "Field Category could not be null")
    @JacksonXmlProperty
    private String category;
    @NotBlank(message = "Field Units in Stock could not be null")
    @JacksonXmlProperty
    private Long unitsInStock;
    @JacksonXmlProperty
    private Long unitsInOrder;
    @JacksonXmlProperty
    @ColumnDefault("false")
    private boolean discontinued;
    @JacksonXmlProperty
    @NotBlank(message = "Field condition could not be null")
    private String condition;
    @JacksonXmlProperty
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
