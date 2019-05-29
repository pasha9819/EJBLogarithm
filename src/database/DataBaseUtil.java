package database;

import database.entity.LogarithmEntity;
import database.entity.LogarithmEntityPK;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class DataBaseUtil {
    @PersistenceContext(unitName = "LogarithmPersistenceUnit")
    private EntityManager entityManager;

    public LogarithmEntity select(LogarithmEntityPK key){
        System.out.println("SELECT");
        return entityManager.find(LogarithmEntity.class, key);
    }

    public void insert(LogarithmEntity entity){
        System.out.println("INSERT");
        entityManager.persist(entity);
    }
}
