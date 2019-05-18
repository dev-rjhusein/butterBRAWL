package xyz.devrj.butterbrawl.services;

import xyz.devrj.butterbrawl.entities.Group;
import xyz.devrj.butterbrawl.entities.UserAccount;
import xyz.devrj.butterbrawl.temp_objects.LogSet;
import xyz.devrj.butterbrawl.temp_objects.TempUser;

import java.security.Principal;
import java.util.List;

public interface MainService {

//    Checks
    boolean getUsernameExists (String username);
    boolean getGroupExists (String groupName);

//    General
    List<Integer> getAllCurrentWeights(String groupName);
    List<Integer> getAllStartingWeights(String groupName);
    List<String> getAllNames(String groupName);
    List<LogSet> getAllWeightLogs(String username);
    void addNewWeightLog(String username, Integer newWeight);

//    Group
    void addGroup(Group newGroup);

//    UserAccount
    UserAccount loadAccount(String username);
    void saveNewAccount(TempUser tempUser);
    void saveUpdateAccount(TempUser tempUser);
    void deleteAccount(Principal principal);





}
