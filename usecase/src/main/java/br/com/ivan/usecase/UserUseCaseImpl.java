package br.com.ivan.usecase;

import br.com.ivan.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserUseCaseImpl implements UserUseCase, AdapterUseCase<UserDAO, User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserOutput insert(UserInput user) {
        User entity = this.toEntity(user);
        //use entity to apply and verify the business rules
        UserDAO userDAO = new UserDAO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge());
        return this.toOutput(userRepository.insert(userDAO));
    }

    @Override
    public UserOutput update(UserInput user) {
        User entity = this.toEntity(user);
        //use entity to apply and verify the business rules
        UserDAO userDAO = new UserDAO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge());
        return this.toOutput(userRepository.update(userDAO));
    }

    @Override
    public void delete(UserInput user) {
        User entity = this.toEntity(user);
        //use entity to apply and verify the business rules
        UserDAO userDAO = new UserDAO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge());
        userRepository.delete(userDAO);
    }

    @Override
    public UserOutput find(Long id) {
        return this.toOutput(userRepository.find(id));
    }

    @Override
    public List<UserOutput> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::toOutput)
                .collect(Collectors.toList());

    }

    @Override
    public UserOutput toOutput(UserDAO out) {
        return new UserOutput(out.getFirstName(), out.getLastName(), out.getEmail(), out.getAge());
    }

    @Override
    public User toEntity(UserInput input) {
        return new User(input.getFirstName(), input.getLastName(), input.getEmail(), input.getAge());
    }
}
