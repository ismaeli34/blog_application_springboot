package com.example.BlogApplicationSpringboot.payloads;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    @NotEmpty(message = "Name cannot be blank!")
    @Size(min=4,message = "Username must be min of 4 characters")
    private String name;
    @Email(message = "Email must be valid!")
    @NotEmpty(message = "Email cannot be blank!")
    private String email;
    @NotEmpty(message = "Password cannot be blank!")
    @Size(min=3, max = 10, message = "Password must be min of 3 characters and maximum of 10 Characters")
    private String password;
    @NotEmpty(message = "About cannot be blank!")
    private String about;
}
