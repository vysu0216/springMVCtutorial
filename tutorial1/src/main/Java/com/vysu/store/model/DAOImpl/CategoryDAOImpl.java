package com.vysu.store.model.DAOImpl;

import com.vysu.store.model.DAO.CategoryDAO;
import com.vysu.store.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addCategory(Category category) {
        sessionFactory.openSession();
        getCurrentSession().saveOrUpdate(category);
    }

    public Category getCategoryById(long id) {
        return (Category) getCurrentSession().get(Category.class, id);
    }

    public Category getCategory(Category category) {
        return (Category) getCurrentSession().get(Category.class,category);
    }

    public void saveCategory(Category category) {
        getCurrentSession().update(category);
    }
}