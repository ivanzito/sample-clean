package br.com.ivan;

import java.util.List;

public interface UserUseCase {

    UserOutput insert(UserInput user);
    UserOutput update(UserInput user);
    void delete(UserInput user);
    UserOutput find(Long id);
    List<UserOutput> findAll();

}
