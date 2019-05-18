package xyz.devrj.butterbrawl.daos;

import xyz.devrj.butterbrawl.entities.Group;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class GroupDaoImpl implements GroupDao {

    private EntityManager entityManager;

    @Autowired
    public GroupDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    /*=======================================
                ADD NEW GROUP ACCOUNT
    ======================================= */
    @Override
    public void addGroup(Group newGroup) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(newGroup);
    }
}
