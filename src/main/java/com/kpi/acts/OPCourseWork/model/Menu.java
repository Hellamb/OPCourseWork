package com.kpi.acts.OPCourseWork.model;

import java.util.*;

public class Menu {
    private Integer menuId;
    private String name;
    private List menuElementsList;

    public Menu(Integer menuId, String name) {
        this.menuId = menuId;
        this.name = name;
        this.menuElementsList = new LinkedList<>();
    }

    public List<MenuElement> getMenuElementsList()
    {
        return menuElementsList;
    }

    public void setMenuElementsList(List menuElements)
    {
        this.menuElementsList = menuElements;
    }

    public void addMenuElement(MenuElement menuElement)
    {
        menuElementsList.add(menuElement);
    }

    public void removeMenuElement(MenuElement menuElement)
    {
        menuElementsList.remove(menuElement);
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(menuId, menu.menuId)
                && Objects.equals(name, menu.name)
                && Objects.equals(menuElementsList, menu.menuElementsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, name, menuElementsList);
    }
}
