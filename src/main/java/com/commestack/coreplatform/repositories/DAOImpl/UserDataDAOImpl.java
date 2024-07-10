package com.commestack.coreplatform.repositories.DAOImpl;

import com.commestack.coreplatform.objects.entity.UserDataEntity;
import com.commestack.coreplatform.repositories.DAO.UserDataDAO;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Repository
public class UserDataDAOImpl implements UserDataDAO {
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public UserDataDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(UserDataEntity theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public UserDataEntity findById(Integer id) {
        return entityManager.find(UserDataEntity.class, id);
    }

    @Override
    public List<UserDataEntity> findAll() {
        // create query
        TypedQuery<UserDataEntity> theQuery = entityManager.createQuery("FROM UserDataEntity order by firstName", UserDataEntity.class);
        // return query results
        return theQuery.getResultList();
    }



    @Override
    @Transactional
    public void update(UserDataEntity theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        // retrieve the student
        UserDataEntity theStudent = entityManager.find(UserDataEntity.class, id);

        // delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM UserDataEntity").executeUpdate();

        return numRowsDeleted;
    }

    @Override
    public UserDataEntity findByName(String firstName, String lastName) {
    //TODO you have to handle in case no result have been returned
        // create query
        TypedQuery<UserDataEntity> theQuery = entityManager.createQuery("FROM UserDataEntity where firstName =: FirstName and lastName =: LastName", UserDataEntity.class);

        theQuery.setParameter("FirstName", firstName);
        theQuery.setParameter("LastName", lastName);

        // return query results
        return theQuery.getResultList().get(0);

    }
}
