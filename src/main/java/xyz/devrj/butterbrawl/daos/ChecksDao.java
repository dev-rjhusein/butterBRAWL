package xyz.devrj.butterbrawl.daos;

import java.util.logging.Logger;

public interface ChecksDao {

    boolean getUsernameExists(String username);
    boolean getGroupExists(String groupName);

}
