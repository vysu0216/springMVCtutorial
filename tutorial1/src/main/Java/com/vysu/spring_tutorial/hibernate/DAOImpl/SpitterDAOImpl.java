package com.vysu.spring_tutorial.hibernate.DAOImpl;

import com.vysu.spring_tutorial.hibernate.DAO.SpitterDAO;
import com.vysu.spring_tutorial.hibernate.entity.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SpitterDAOImpl implements SpitterDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public SpitterDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addSpitter(Spitter spitter) {
        sessionFactory.openSession();
        getCurrentSession().save(spitter);
    }

    public Spitter getSpitterById(int id) {
        return (Spitter) getCurrentSession().get(Spitter.class, id);
    }

    public void saveSpitter(Spitter spitter) {
        getCurrentSession().update(spitter);
    }
}
