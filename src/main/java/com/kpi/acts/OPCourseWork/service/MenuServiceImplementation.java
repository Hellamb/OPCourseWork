package com.kpi.acts.OPCourseWork.service;

import com.kpi.acts.OPCourseWork.dao.DaoFactory;
import com.kpi.acts.OPCourseWork.model.Menu;
import com.kpi.acts.OPCourseWork.model.MenuElement;

import java.util.Collection;

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
    public Collection<MenuElement> getAllMenuElements(Menu menu) {
        return menu.getMenuElementsList();
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
    public void removeMenuElement(Menu menu, MenuElement menuElement) {
        daoFactory.getMenuDao().removeMenuElement(menu, menuElement);
    }

    @Override
    public void addMenu(String name) {
        daoFactory.getMenuDao().addMenu(name);
    }

    @Override
    public void addMenuElement(Menu menu, String name, String imageUrl, Integer price) {
        daoFactory.getMenuDao().addMenuElement(menu, name, imageUrl, price);
    }
}
