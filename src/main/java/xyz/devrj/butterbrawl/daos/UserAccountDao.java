package xyz.devrj.butterbrawl.daos;

import xyz.devrj.butterbrawl.entities.UserAccount;

import java.security.Principal;

public interface UserAccountDao {
    UserAccount loadAccount(String username);
    void addNewAccount(UserAccount userAccount);
    void saveUpdateAccount(UserAccount userAccount);
    void deleteAccount(Principal principal);
}


