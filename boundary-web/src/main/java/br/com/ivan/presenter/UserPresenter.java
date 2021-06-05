package br.com.ivan.presenter;

import br.com.ivan.AdapterOutput;
import br.com.ivan.UserOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPresenter implements AdapterOutput<UserOutput, UserPresenter> {

    private String name;
    private String email;
    private String age;

    @Override
    public UserPresenter toPresenter(UserOutput input) {
        return new UserPresenter(
                input.getFirstName().concat(" ").concat(input.getLastName()),
                input.getEmail(),
                input.getAge());
    }
}
