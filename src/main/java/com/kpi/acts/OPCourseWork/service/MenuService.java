package com.kpi.acts.OPCourseWork.service;

import com.kpi.acts.OPCourseWork.model.Menu;
import com.kpi.acts.OPCourseWork.model.MenuElement;

import java.util.Collection;
import java.util.Map;

public interface MenuService {
    Collection<Menu> getAllMenus();
    Menu getMenuById(Integer menuId);
    void removeMenu(Menu menu);
    void removeMenuElement(Map<String,String[]> params);
    void addMenu(String name);
    void addMenuElement(Menu menu, String name, String imageUrl, Integer price, String description);

}
