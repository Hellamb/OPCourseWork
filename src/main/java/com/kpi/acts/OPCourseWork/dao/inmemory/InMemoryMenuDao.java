package com.kpi.acts.OPCourseWork.dao.inmemory;

import com.kpi.acts.OPCourseWork.dao.MenuDao;
import com.kpi.acts.OPCourseWork.dao.MenuElementDao;
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
    public void removeMenu(Integer menuId) {
        Menu menu = this.get(menuId);
        if(menuId == null) return;
        this.delete(menu);
    }
}