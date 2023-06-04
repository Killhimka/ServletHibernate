package org.example.MySQLHw;

import org.hibernate.Session;
import ru.javabegin.hibernate.entity.Pets;
import ru.javabegin.hibernate.utils.HibernateSessionFactory;

import java.util.List;

public class PetDB {
    static Session session = null;
    public static List<Pets> select() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List <Pets> pets = session.createQuery("select a from Pets a", Pets.class).list();
        session.getTransaction().commit();
        return pets;
    }

    public static Pets selectOne(int id) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Pets pet = session.get(Pets.class,id);
        session.getTransaction().commit();
            return pet;
    }
    public static int insert (Pets pet){
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(pet);
        session.getTransaction().commit();
    return 0;
    }
    public static Pets update (Pets pet){
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(pet);
        session.getTransaction().commit();
        return pet;
    }
    public static int delete (int id){
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Pets pets = session.get(Pets.class,id);
        session.remove(pets);
        session.getTransaction().commit();
        return 0;
    }
}
