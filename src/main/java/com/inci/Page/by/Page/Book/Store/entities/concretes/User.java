package com.inci.Page.by.Page.Book.Store.entities.concretes;

import com.inci.Page.by.Page.Book.Store.entities.abstracts.BasicEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Collection;
import java.util.List;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BasicEntity implements UserDetails { //   UserDetails Interface used for Spring Security

    //ATTRIBUTES:
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @Column(name = "international_id")
    private String internationalId;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    private transient Integer age = getAge(birthday);


    //METHODS:

    //  Returns age calculated given birthdate
    public  Integer getAge(LocalDateTime birthday){
        if (birthday == null){
            return null;
        }
        LocalDate currentDate = LocalDate.now();
        return Period.between(LocalDate.from(birthday), currentDate).getYears();
    }

    @Override
    //  Returns a collection of user authorities(roles)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //  creates a list containing a single SimpleGrantedAuthority object
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    //  Returns boolean to indicate whether the user's account is not expired
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //  Returns boolean to indicate whether the user's account is not locked
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    //  Returns boolean and checks whether the user's credentials (such as passwords) are not expired
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    //   Returns boolean and checks whether the user account is enabled
    public boolean isEnabled() {
        return true;
    }
}
