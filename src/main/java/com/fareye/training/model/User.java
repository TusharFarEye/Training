package com.fareye.training.model;

import com.fareye.training.service.UserService;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean verified;
    private String created;
    private String modified;
    private String password;
    private String role;
    private boolean active;

    // Getter and Setters overrides

    public void setPassword(String password) {
        this.password = password;
        setCreated();
        setModified();
    }

    public void setCreated() {
        if(this.created==null){
            LocalDateTime createdDate= LocalDateTime.now();
            this.created = createdDate.toString();
        }
    }

    public void setModified() {
        this.modified = LocalDateTime.now().toString();
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
                ", role='" + role + '\'' +
                ", active=" + active +
                '}';
    }

}
