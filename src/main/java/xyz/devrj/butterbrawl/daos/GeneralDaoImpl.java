package xyz.devrj.butterbrawl.daos;

import xyz.devrj.butterbrawl.temp_objects.LogSet;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GeneralDaoImpl implements GeneralDao{

    Logger logger = LoggerFactory.getLogger(getClass());

    //JDBC Template for JDBC use
    private JdbcTemplate jdbc;

    //Entity Manager for Hibernate use (JPA STANDARD)
    private EntityManager entityManager;

    @Autowired
    public GeneralDaoImpl(JdbcTemplate jdbc, EntityManager entityManager) {
        this.jdbc = jdbc;
        this.entityManager = entityManager;
    }


    /*=======================================
    Get list of group's user's current weights
    ======================================= */
    @Override
    public List<Integer> getAllCurrentWeights(String groupName) {
        Session session = entityManager.unwrap(Session.class);

        Query<Integer> query = session.createQuery("SELECT currentWeight FROM UserAccount WHERE groupName=:gName", Integer.class);
        query.setParameter("gName", groupName);

        return query.getResultList();
    }


    /*=======================================
    //Get list of group's user's starting weights
    ======================================= */
    @Override
    public List<Integer> getAllStartingWeights(String groupName) {
        Session session = entityManager.unwrap(Session.class);

        Query<Integer> query = session.createQuery("SELECT startingWeight FROM UserAccount WHERE groupName=:gName", Integer.class);
        query.setParameter("gName", groupName);

        return query.getResultList();
    }

    /*=======================================
    //Get list of group's user's first names
    ======================================= */
    @Override
    public List<String> getAllNames(String groupName) {
        Session session = entityManager.unwrap(Session.class);

        Query<String> query = session.createQuery("SELECT userName FROM UserAccount WHERE groupName=:gName", String.class);
        query.setParameter("gName", groupName);

        return query.getResultList();
    }


    /*=======================================
    //Get list of ALL USER'S WEIGHT LOGS
    ======================================= */
    @Override
    public List<LogSet> getAllWeightLogs(String username) {
        //Get date and weights from user weight log
        List <String>  dateList = jdbc.queryForList("SELECT record_date FROM " + username + "_weight_log", String.class);
        List <String> weightList = jdbc.queryForList("SELECT record_weight FROM " + username + "_weight_log", String.class);
        List<LogSet> datesAndWeights = new ArrayList<>();

        //Save date/weights in a list together using custom LogSet objects
        for(int i = 0; i < dateList.size(); i++){
            datesAndWeights.add(new LogSet(dateList.get(i), weightList.get(i)));
        }

        return datesAndWeights;
    }


    /*=======================================
            ADD NEW USER WEIGHT LOG
    ======================================= */
    @Override
    public void addNewWeightLog(String username, Integer newWeight) {

        //Add the new weight to the unique weight log table
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(currentDate.toString(), format);

        jdbc.execute("INSERT INTO " + username + "_weight_log (record_date, record_weight) VALUES ('" + date + "', " + newWeight + ");");

        //Add the new weight to the current_weight column in the user_account table
        jdbc.update("UPDATE user_account SET current_weight="+newWeight+" WHERE username='"+username+"';");
    }
}
