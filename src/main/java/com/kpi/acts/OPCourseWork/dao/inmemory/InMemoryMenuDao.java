package com.kpi.acts.OPCourseWork.dao.inmemory;

import com.kpi.acts.OPCourseWork.dao.MenuDao;
import com.kpi.acts.OPCourseWork.model.Menu;
import com.kpi.acts.OPCourseWork.model.MenuElement;

public class InMemoryMenuDao extends InMemoryAbstractDao<Menu> implements MenuDao {

    public InMemoryMenuDao(InMemoryDatabase database) {
        super(database.menu, Menu::getMenuId, Menu::setMenuId, database);
    }


    @Override
    public void addMenu(String name) {
        Menu menu = new Menu(-1,name);
        this.insert(menu, true);
    }

    @Override
    public void removeMenu(Menu menu) {
        this.delete(menu);
    }

    @Override
    public void addMenuElement(Menu menu, String name, String imageUrl, Integer price, String description) {
        MenuElement menuElement = new MenuElement(name, imageUrl, price, description);
        menu.addMenuElement(menuElement);
    }

    @Override
    public void removeMenuElement(Menu menu, MenuElement menuElement) {
        menu.removeMenuElement(menuElement);
    }

}