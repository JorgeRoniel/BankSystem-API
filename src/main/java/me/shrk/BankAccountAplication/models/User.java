package me.shrk.BankAccountAplication.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

@Entity(name = "tab_user")
public class User implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    private UserRoles role;

    


    public User() {
    }

    public User(String name, String email, String password, Account account, Card card, UserRoles role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.account = account;
        this.card = card;
        this.role = role;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserRoles getRole() {
        return role;
    }
    public void setRole(UserRoles role) {
        this.role = role;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRoles.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
    
    @Override
    public String getUsername() {
        return email;
    }

    

    
}
