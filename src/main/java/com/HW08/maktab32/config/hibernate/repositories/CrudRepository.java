package com.HW08.maktab32.config.hibernate.repositories;

import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.User;
import com.HW08.maktab32.entities.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class CrudRepository<Entity, ID extends Serializable> {

    protected abstract Class<Entity> getEntityClass();

    public Entity save(Entity entity) {
        getSession().getTransaction().begin();
        getSession().save(entity);
        getSession().getTransaction().commit();
        return entity;
    }

    public Entity update(Entity entity) {
        getSession().beginTransaction();
        getSession().update(entity);
        getSession().getTransaction().commit();
        return entity;
    }

    public void remove(Entity entity) {
        getSession().beginTransaction();
        getSession().remove(entity);
        getSession().getTransaction().commit();
    }

    public void removeById(ID id) {
        Entity entity = findById(id);
        if (entity != null) {
            getSession().beginTransaction();
            getSession().remove(entity);
            getSession().getTransaction().commit();
        }
    }

    public Entity findById(ID id) {
        getSession().beginTransaction();
        Entity entity = getSession().get(getEntityClass(), id);
        getSession().getTransaction().commit();
        return entity;
    }

    public List<Entity> findAll() {
        getSession().beginTransaction();
        Query<Entity> query = getSession()
                .createQuery("from " + getEntityClass().getName(), getEntityClass());
        List<Entity> entities = query.list();
        getSession().getTransaction().commit();
        return entities;
    }

    public List<Entity> findAll(int start, int row) {
        getSession().beginTransaction();
        Query<Entity> query = getSession()
                .createQuery("from " + getEntityClass().getName(), getEntityClass());
        query.setFirstResult(start);
        query.setMaxResults(row);
        List<Entity> entities = query.list();
        getSession().getTransaction().commit();
        return entities;
    }

    public List<Entity> findAll(Predicate<Entity> entityPredicate){
        List<Entity> entities = findAll();
        List<Entity> entityList= entities.stream().filter(entityPredicate).collect(Collectors.toList());

        return entityList;

    }

    public <T> List<T> findAll(Function<Entity,T> entityFunction){

       List<T> entities = findAll().stream().map(entityFunction).collect(Collectors.toList());
       return entities;
    }

    private Session getSession() {
        return HibernateUtil.getSession();
    }

}
