package xyz.devrj.butterbrawl.daos;

import xyz.devrj.butterbrawl.entities.UserAccount;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Repository
public class UserAccountDaoImpl implements UserAccountDao{

    private Logger logger = LoggerFactory.getLogger(getClass());

    //JDBC Template for JDBC use
    private JdbcTemplate jdbc;

    //Entity Manager for Hibernate use (JPA STANDARD)
    private EntityManager entityManager;

    @Autowired  //Inject the entity manager into the application (Constructor injection)
    public UserAccountDaoImpl(EntityManager entityManager, JdbcTemplate jdbc){
        this.jdbc = jdbc;
        this.entityManager = entityManager;
    }

    /*=======================================
                LOAD USER ACCOUNT
    ======================================= */
    @Override
    public UserAccount loadAccount(String username) {
        //Get the session
        Session session = entityManager.unwrap(Session.class);

        //Get the user's account
        return session.createQuery("FROM UserAccount WHERE userName='" + username + "'", UserAccount.class).getSingleResult();

    }

    /*=======================================
            SAVE NEW USER ACCOUNT
    ======================================= */
    @Override
    public void addNewAccount(UserAccount userAccount) {
        Session session = entityManager.unwrap(Session.class);

        String username = userAccount.getUsername();

        //Create a weight log table for the new user
        jdbc.execute("CREATE TABLE " + username + "_weight_log(" +
                "id int not null auto_increment," +
                "record_date date not null," +
                "record_weight int not null," +
                "primary key(id))");

        //Add the new (first)  weight to the new weight log table using current date
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(currentDate.toString(), format);

        jdbc.execute("INSERT INTO " + username + "_weight_log (record_date, record_weight) VALUES ('" + date + "', " + userAccount.getCurrentWeight() + ");");

        logger.info(">>>>>>>>>>>Save is left");
        //Save the new account to user_account
        session.save(userAccount);
    }

    /*=======================================
            UPDATE USER ACCOUNT
    ======================================= */
    @Override
    public void saveUpdateAccount(UserAccount userAccount) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(userAccount);
    }

    /*=======================================
            DELETE  USER ACCOUNT
    ======================================= */
    @Override
    public void deleteAccount(Principal principal) {

            jdbc.execute("DELETE FROM user_account WHERE username='" + principal.getName() +"'");
            jdbc.execute("DROP TABLE " + principal.getName() + "_weight_log");

    }
}
