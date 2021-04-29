package com.kpi.acts.OPCourseWork.dao;

import com.kpi.acts.OPCourseWork.model.Menu;
import com.kpi.acts.OPCourseWork.model.MenuElement;

public interface MenuDao extends AbstractDao<Menu> {
    void addMenu(String name);
    void removeMenu(Menu menu);
    void addMenuElement(Menu menu, String name, String imageUrl, Integer price);
    void removeMenuElement(Menu menu, MenuElement menuElement);
}
