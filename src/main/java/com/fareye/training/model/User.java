package com.fareye.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
public class User {
    @NotNull
    private String firstName;
    private String lastName;
    @NotNull
    private String email;
    private boolean verified;
    private LocalDateTime created;
    private LocalDateTime modified;
    @NotNull
    private String password;
    private String hashedPassword;
    @NotNull
    private String role;
    private boolean active;

    // Getter and Setters overrides

    public void setPassword(String password) {
        this.password = password;
        setHashedPassword();
        setCreated();
        setModified();
    }

    public void setCreated() {
        if(this.created==null){
            LocalDateTime createdDate= LocalDateTime.now();
            this.created = createdDate;
        }
    }

    public void setModified() {
        this.modified = LocalDateTime.now();
    }

    public void setHashedPassword() {this.hashedPassword = hashPassword(this.password);}

    // password hashing

    private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", verified=" + verified +
                ", created=" + created +
                ", modified=" + modified +
                ", password='" + password + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", role='" + role + '\'' +
                ", active=" + active +
                '}';
    }
}
