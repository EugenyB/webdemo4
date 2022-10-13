package com.example.webdemo4.beans;

import com.example.webdemo4.dao.GroupDao;
import com.example.webdemo4.data.Gruppa;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class GroupBean implements Serializable {

    @EJB
    GroupDao groupDao;

    private Gruppa group = new Gruppa();

    public List<Gruppa> getGroups() {
        return groupDao.findAll();
    }

    public Gruppa getGroup() {
        return group;
    }

    public void setGroup(Gruppa group) {
        this.group = group;
    }

    public void add() {
        groupDao.add(group);
        group = new Gruppa();
    }

    public void delete(Gruppa g) {
        groupDao.delete(g);
    }

    public String edit(Gruppa g) {
        group = g;
        return "edit_group";
    }

    public String update() {
        groupDao.update(group);
        group = new Gruppa();
        return "index";
    }

    public String showStudents(Gruppa g) {
        group = g;
        return "students_by_group";
    }
}
