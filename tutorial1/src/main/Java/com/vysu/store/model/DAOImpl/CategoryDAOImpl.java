package com.vysu.store.model.DAOImpl;

import com.vysu.store.model.DAO.CategoryDAO;
import com.vysu.store.model.entity.Category;
import com.vysu.store.model.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Category> getAllCategories(){
        return getCurrentSession().createQuery("from Category").list();
    }

    public List<Category> getRootCategories() {
        return getCurrentSession().createQuery("from Category as cat where cat.isTopLevel = 1").list();
    }

    public Category getCategory(Category category) {
        return (Category) getCurrentSession().get(Category.class,category);
    }

    public void saveCategory(Category category) {
        getCurrentSession().update(category);
    }
}