package xyz.devrj.butterbrawl.daos;

import xyz.devrj.butterbrawl.entities.Group;
import xyz.devrj.butterbrawl.entities.UserAccount;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ChecksDaoImpl implements ChecksDao {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //JDBC Template for JDBC use
    private JdbcTemplate jdbc;

    //Entity Manager for Hibernate use (JPA STANDARD)
    private EntityManager entityManager;

    @Autowired
    public ChecksDaoImpl(EntityManager entityManager, JdbcTemplate jdbc) {
        this.entityManager = entityManager;
        this.jdbc = jdbc;
    }

    /*=======================================
        CHECK IF USERNAME IS AVAILABLE
    ======================================= */
    @Override
    public boolean getUsernameExists(String username) {
        Session session = entityManager.unwrap(Session.class);

        Query<UserAccount> query = session.createQuery("FROM UserAccount WHERE username=:uName", UserAccount.class);
        query.setParameter("uName", username);


        UserAccount tempUser;
        try{
            tempUser = query.getSingleResult();
        }catch(Exception e){
            tempUser = null;
            logger.info(">>>>>>>Username '" + username + "' is available!");
        }

        return tempUser==null;

    }


    /*=======================================
        CHECK IF GROUP EXISTS IN DATABASE
    ======================================= */
    @Override
    public boolean getGroupExists(String groupName) {
        Session session = entityManager.unwrap(Session.class);

        Query<Group> query = session.createQuery("FROM Group WHERE groupName=:gName", Group.class);
        query.setParameter("gName", groupName);


        Group tempGroup;
        try{
            tempGroup = query.getSingleResult();
            logger.info(">>>>>>>ChecksImpl: Group Name '" + tempGroup + "' exists!");
        }catch(Exception e){
            tempGroup = null;
            logger.info(">>>>>>>ChecksImpl: Group Name '" + tempGroup + "' is available!");
        }

        return tempGroup==null;

    }

}
