package xyz.devrj.butterbrawl.daos;

import xyz.devrj.butterbrawl.temp_objects.LogSet;

import java.util.List;

public interface GeneralDao {
    List<Integer> getAllCurrentWeights(String groupName);
    List<Integer> getAllStartingWeights(String groupName);
    List<String> getAllNames(String groupName);


    List<LogSet> getAllWeightLogs(String username);
    void addNewWeightLog(String username, Integer newWeight);
}
