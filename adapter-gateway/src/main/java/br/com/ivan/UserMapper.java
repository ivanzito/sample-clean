package br.com.ivan;

import br.com.ivan.entitty.UserEntity;

public class UserMapper {

    private UserMapper() { }

    public static UserEntity map(UserDAO user) {
        return new UserEntity(
                0L,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge()
        );
    }

    public static UserDAO map(UserEntity user) {
        return new UserDAO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge()
        );
    }
}
