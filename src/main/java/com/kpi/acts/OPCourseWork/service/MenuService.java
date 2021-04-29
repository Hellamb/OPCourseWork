package com.kpi.acts.OPCourseWork.service;

import com.kpi.acts.OPCourseWork.model.Menu;
import com.kpi.acts.OPCourseWork.model.MenuElement;

import java.util.Collection;

public interface MenuService {
    Collection<Menu> getAllMenus();
    Collection<MenuElement> getAllMenuElements(Menu menu);
    Menu getMenuById(Integer menuId);
    void removeMenu(Menu menu);
    void removeMenuElement(Menu menu, MenuElement menuElement);
    void addMenu(String name);
    void addMenuElement(Menu menu, String name, String imageUrl, Integer price);

}
