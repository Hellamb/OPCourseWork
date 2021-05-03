package com.kpi.acts.OPCourseWork.model;

import java.util.Objects;

public class MenuElement {
    private String name;
    private String imageUrl;
    private Integer price;
    private String description;

    public MenuElement(String name, String imageUrl, Integer price, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuElement that = (MenuElement) o;
        return Objects.equals(name, that.name) && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imageUrl, price);
    }

    @Override
    public String toString() {
        return "MenuElement{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
