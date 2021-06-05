package br.com.ivan;

import br.com.ivan.dto.UserRequest;
import br.com.ivan.presenter.UserPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserEndpoint implements GenericCrud<UserRequest, UserPresenter> {

    @Autowired
    private UserUseCase userUseCase;

    private final UserPresenter userPresenter = new UserPresenter();


    @Override
    @PostMapping
    public UserPresenter insert(@RequestBody UserRequest userRequest) {
        UserInput userInput = userRequest.toInput(userRequest);
        UserOutput output = userUseCase.insert(userInput);
        return userPresenter.toPresenter(output);
    }

    @Override
    @PutMapping
    public UserPresenter update(@RequestBody UserRequest userRequest) {
        UserInput userInput = userRequest.toInput(userRequest);
        UserOutput output = userUseCase.update(userInput);
        return userPresenter.toPresenter(output);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody UserRequest userRequest) {
        UserInput userInput = userRequest.toInput(userRequest);
        userUseCase.delete(userInput);
    }

    @Override
    @GetMapping("/{id}")
    public UserPresenter find(@PathVariable("id") Long id) {
        UserOutput output = userUseCase.find(id);
        return userPresenter.toPresenter(output);
    }

    @Override
    @GetMapping
    public List<UserPresenter> findAll() {
        List<UserOutput> output = userUseCase.findAll();
        return output
                .stream()
                .map(userPresenter::toPresenter)
                .collect(Collectors.toList());
    }

/*    @GetMapping
    public String helloWorld() {
        return "Hello world";
    }*/
}
