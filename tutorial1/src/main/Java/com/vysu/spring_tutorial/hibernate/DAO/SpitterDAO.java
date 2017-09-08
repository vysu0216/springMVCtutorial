package com.vysu.spring_tutorial.hibernate.DAO;


import com.vysu.spring_tutorial.hibernate.entity.Spitter;

public interface SpitterDAO {

    void addSpitter(Spitter spitter);

    Spitter getSpitterById(int id);

    void saveSpitter(Spitter spitter);
}
