package com.kpi.acts.OPCourseWork.model;

public class MenuElement {
    private Integer menuElementId;
    private String name;
    private String imageUrl;
    private Integer price;

    public MenuElement(Integer menuElementId,String name, String imageUrl, Integer price) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
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

    public Integer getMenuElementId() {
        return menuElementId;
    }

    public void setMenuElementId(Integer menuElementId) {
        this.menuElementId = menuElementId;
    }
}
