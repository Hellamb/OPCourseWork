package com.kpi.acts.OPCourseWork.dao;

import com.kpi.acts.OPCourseWork.model.Menu;

public interface MenuDao extends AbstractDao<Menu> {
    void addMenu(String name);
    void removeMenu(Integer menuId);
}
