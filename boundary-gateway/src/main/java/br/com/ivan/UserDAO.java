package br.com.ivan;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public
class UserDAO {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
}
