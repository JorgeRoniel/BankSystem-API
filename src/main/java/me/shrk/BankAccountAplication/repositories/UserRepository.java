package me.shrk.BankAccountAplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import me.shrk.BankAccountAplication.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    UserDetails findByEmail(String email);
    
    boolean existsByAccountNumber(String number);
    boolean existsByCardNumber(String number);
}
