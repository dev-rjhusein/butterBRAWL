package xyz.devrj.butterbrawl.services;

import xyz.devrj.butterbrawl.daos.ChecksDao;
import xyz.devrj.butterbrawl.daos.GeneralDao;
import xyz.devrj.butterbrawl.daos.GroupDao;
import xyz.devrj.butterbrawl.daos.UserAccountDao;
import xyz.devrj.butterbrawl.entities.Group;
import xyz.devrj.butterbrawl.entities.UserAccount;
import xyz.devrj.butterbrawl.temp_objects.LogSet;
import xyz.devrj.butterbrawl.temp_objects.TempUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MainServiceImpl implements MainService {
    Logger logger = LoggerFactory.getLogger(getClass());

    private UserAccountDao userAccountDao;
    private GeneralDao generalDao;
    private ChecksDao checksDao;
    private GroupDao groupDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MainServiceImpl(UserAccountDao userAccountDao, GeneralDao generalDao, PasswordEncoder passwordEncoder, ChecksDao checksDao, GroupDao groupDao) {
        this.userAccountDao = userAccountDao;
        this.generalDao = generalDao;
        this.passwordEncoder = passwordEncoder;
        this.checksDao = checksDao;
        this.groupDao = groupDao;
    }

    @Transactional
    @Override
    public UserAccount loadAccount(String username) {

        return userAccountDao.loadAccount(username);
    }

    @Transactional
    @Override
    public List<Integer> getAllCurrentWeights(String groupName) {
        return generalDao.getAllCurrentWeights(groupName);
    }


    @Transactional
    @Override
    public List<Integer> getAllStartingWeights(String groupName) {
        return generalDao.getAllStartingWeights(groupName);
    }

    @Transactional
    @Override
    public List<String> getAllNames(String groupName) {
        return generalDao.getAllNames(groupName);
    }

    @Transactional
    @Override
    public List<LogSet> getAllWeightLogs(String username) {
        List<LogSet> sets = generalDao.getAllWeightLogs(username);


        //Convert format of dates to "Day Month Date"
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i < sets.size(); i++){
            String dateToFormat = sets.get(i).getDate();
            try {
                sets.get(i).setDate(format.parse(dateToFormat).toString().substring(0,10));
            }catch (ParseException e){
                logger.warn(">>>>>>> Date parse exception in MainServiceImpl/getAllWeightLogs");
            }
        }

        return sets;
    }

    @Transactional
    @Override
    public void addNewWeightLog(String username, Integer newWeight) {
        generalDao.addNewWeightLog(username, newWeight);
    }

    @Transactional
    @Override
    public void saveNewAccount(TempUser tempUser) {
        //Ensure birthday is mysql date data-type format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate bday = LocalDate.parse(tempUser.getBirthday(), formatter);

        //Convert tempUser to a user_account entity (hibernate use)
        UserAccount newUser = new UserAccount(tempUser);
        newUser.setPassword(passwordEncoder.encode(tempUser.getPassword()));
        newUser.setBirthday(bday.toString());

        //Set current weight to starting weight before save
        newUser.setCurrentWeight(newUser.getStartingWeight());

        userAccountDao.addNewAccount(newUser);
    }


    @Transactional
    @Override
    public boolean getUsernameExists(String username) {
        return checksDao.getUsernameExists(username);
    }

    @Transactional
    @Override
    public boolean getGroupExists(String groupName) {
        return checksDao.getGroupExists(groupName);
    }

    @Transactional
    @Override
    public void addGroup(Group newGroup) {
        groupDao.addGroup(newGroup);
    }

    @Transactional
    @Override
    public void saveUpdateAccount(TempUser tempUser) {

        //Ensure birthday is mysql date data-type format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate bday = LocalDate.parse(tempUser.getBirthday(), formatter);

        //Convert tempUser to a user_account entity (hibernate use)
        UserAccount newUser = new UserAccount(tempUser);
        newUser.setPassword(passwordEncoder.encode(tempUser.getPassword()));
        newUser.setBirthday(bday.toString());

        userAccountDao.saveUpdateAccount(newUser);
    }

    @Transactional
    @Override
    public void deleteAccount(Principal principal) {
        userAccountDao.deleteAccount(principal);
    }
}
