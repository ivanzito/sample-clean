package br.com.ivan;

import br.com.ivan.entitty.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JpaUserRepository repository;

    @Override
    public UserDAO insert(UserDAO user) {
        UserEntity entity = UserMapper.map(user);
        return UserMapper.map(repository.save(entity));
    }

    @Override
    public UserDAO update(UserDAO user) {
        //TODO implement
        return null;
    }

    @Override
    public void delete(UserDAO user) {
        UserEntity entity = UserMapper.map(user);
        repository.delete(entity);
    }

    @Override
    public UserDAO find(Long id) {
        return repository.findById(id)
                .map(UserMapper::map)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<UserDAO> findAll() {
        return repository.findAll()
                .stream()
                .map(UserMapper::map)
                .collect(Collectors.toList());
    }
}
