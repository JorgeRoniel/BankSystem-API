package me.shrk.BankAccountAplication.services;

import me.shrk.BankAccountAplication.dtos.RegisterDTO;
import me.shrk.BankAccountAplication.dtos.UpdateDTO;
import me.shrk.BankAccountAplication.models.User;

public interface UserService {
    
    public User create(RegisterDTO user);
    public Boolean update(Long id, UpdateDTO user);
    public void delete(Long id);


    public User findById(Long id);
    public Iterable<User> listUsers();
}
