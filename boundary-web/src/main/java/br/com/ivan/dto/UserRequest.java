package br.com.ivan.dto;

import br.com.ivan.AdapterInput;
import br.com.ivan.UserInput;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest implements AdapterInput<UserRequest, UserInput> {
    private String firstName;
    private String lastName;
    private String email;
    private String age;


    @Override
    public UserInput toInput(UserRequest request) {
        return new UserInput(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getAge());
    }
}
