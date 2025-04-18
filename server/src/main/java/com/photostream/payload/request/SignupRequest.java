package com.photostream.payload.request;

import com.photostream.annotations.PasswordMatches;
import com.photostream.annotations.ValidEmail;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordMatches
public class SignupRequest {
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be empty")
    @ValidEmail
    private String email;
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;
    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 6)
    private String password;
    private String confirmPassword;
}
