package com.example.shoppinglistapplication.models.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotBlank(message = "Username cannot be empty str")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Password cannot be empty str")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    private String password;

    @NotBlank(message = "Password cannot be empty str")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    private String confirmPassword;

    @NotNull
    @Email(message = "Email must be valid")
    private String email;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
