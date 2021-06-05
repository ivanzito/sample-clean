package br.com.ivan;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String age;

    //methods from domain here
}
