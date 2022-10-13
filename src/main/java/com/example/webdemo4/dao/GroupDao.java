package com.example.webdemo4.dao;

import com.example.webdemo4.data.Gruppa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class GroupDao {
    @PersistenceContext
    EntityManager em;

    public List<Gruppa> findAll() {
        return em.createNamedQuery("Gruppa.findAll", Gruppa.class).getResultList();
    }

    public void add(Gruppa group) {
        em.persist(group);
    }

    public void delete(Gruppa g) {
        Gruppa gruppa = em.find(Gruppa.class, g.getId());
        em.remove(gruppa);
    }

    public void update(Gruppa g) {
        Gruppa gruppa = em.find(Gruppa.class, g.getId());
        gruppa.setTitle(g.getTitle());
        em.merge(gruppa);
    }
}
