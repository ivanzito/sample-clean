package br.com.ivan;

import java.util.List;

public interface UserRepository {

    UserDAO insert(UserDAO user);
    UserDAO update(UserDAO user);
    void delete(UserDAO user);
    UserDAO find(Long id);
    List<UserDAO> findAll();


}
