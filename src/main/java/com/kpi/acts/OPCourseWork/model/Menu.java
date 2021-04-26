package com.kpi.acts.OPCourseWork.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

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
}
