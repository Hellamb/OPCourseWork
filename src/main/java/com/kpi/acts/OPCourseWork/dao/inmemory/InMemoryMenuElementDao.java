package com.kpi.acts.OPCourseWork.dao.inmemory;

import com.kpi.acts.OPCourseWork.dao.MenuElementDao;
import com.kpi.acts.OPCourseWork.model.Menu;
import com.kpi.acts.OPCourseWork.model.MenuElement;

import java.util.Collection;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class InMemoryMenuElementDao extends InMemoryAbstractDao<MenuElement> implements MenuElementDao {

    public InMemoryMenuElementDao(InMemoryDatabase database) {
        super(database.menuElements, MenuElement::getMenuElementId, MenuElement::setMenuElementId, database);
    }

    @Override
    public Collection<MenuElement> findByMenuId(Integer menuId) {
        return null;
    }

    @Override
    public void addMenuElement(Menu menu, String name, String imageUrl, Integer price) {
        MenuElement menuElement = new MenuElement(-1, name, imageUrl, price);

        this.insert(menuElement, true);
        menu.addMenuElement(menuElement);
    }

    @Override
    public void removeMenuElement(Integer menuId) {
        MenuElement menuElement = this.get(menuId);
        if(menuId == null) return;
        this.delete(menuElement);
    }
}
