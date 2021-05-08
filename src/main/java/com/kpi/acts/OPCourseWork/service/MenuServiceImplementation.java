package com.kpi.acts.OPCourseWork.service;

import com.kpi.acts.OPCourseWork.dao.DaoFactory;
import com.kpi.acts.OPCourseWork.model.Menu;
import com.kpi.acts.OPCourseWork.model.MenuElement;

import java.util.Collection;
import java.util.Map;

public class MenuServiceImplementation implements MenuService{
    DaoFactory daoFactory;

    public MenuServiceImplementation(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Collection<Menu> getAllMenus() {
        return daoFactory.getMenuDao().findAll();
    }

    @Override
    public Menu getMenuById(Integer menuId) {
        return daoFactory.getMenuDao().get(menuId);
    }

    @Override
    public void removeMenu(Menu menu) {
        daoFactory.getMenuDao().removeMenu(menu);
    }

    @Override
    public void removeMenuElement(Map<String,String[]> params) {
        String name = params.get("name")[0];
        Integer price = Integer.parseInt(params.get("price")[0]);
        String imageUrl = params.get("imageUrl")[0];
        String description = params.get("description")[0];
        MenuElement menuElement = new MenuElement(name, imageUrl, price, description);
        Integer menuId = Integer.parseInt(params.get("menuId")[0]);
        Menu menu = getMenuById(menuId);
        daoFactory.getMenuDao().removeMenuElement(menu, menuElement);
    }

    @Override
    public void addMenu(String name) {
        daoFactory.getMenuDao().addMenu(name);
    }

    @Override
    public void addMenuElement(Menu menu, String name, String imageUrl, Integer price, String description) {
        daoFactory.getMenuDao().addMenuElement(menu, name, imageUrl, price, description);
    }
}
