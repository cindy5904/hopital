package org.example.tphopital.service;

import org.example.tphopital.exception.NotFountException;
import org.example.tphopital.exception.UserAlreadyExists;
import org.example.tphopital.exception.WrongPasswordException;
import org.example.tphopital.model.User;
import org.example.tphopital.repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    public User signUp(String name, String email, String password){
        User user = new User(name,email,password);
        User userFound = userRepository.findByEmail(email);
        if(userFound == null){
            return userRepository.add(user);
        }else {
            throw new UserAlreadyExists("Utilisateur existe déjà !!!");
        }
    }

    public User signIn(String email, String password){
        User userFound = userRepository.findByEmail(email);
        if(userFound != null){
            if(password.equals(userFound.getPassword())){
                return userFound;
            }else {
                throw new WrongPasswordException("mot de passe érroné");
            }
        }else {
            throw new UserAlreadyExists("utilisateur non trouvé");
        }
    }

    public User findById(int id){
        User userFound = userRepository.finfById(id);
        if(userFound != null){
            return userFound;
        }else {
            throw new NotFountException("User not found !!!");
        }

    }
}
