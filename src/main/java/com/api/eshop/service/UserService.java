package com.api.eshop.service;

import com.api.eshop.controller.DTO.UsersDTO;
import com.api.eshop.domain.Users;
import com.api.eshop.payload.LoginRequest;
import com.api.eshop.repository.UserRepository;
import com.api.eshop.service.utilities.ActivationCodeManager;
import com.api.eshop.service.utilities.SmsManager;
import com.api.eshop.service.utilities.TokenCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


//    public Map<String, String> login(LoginRequest entity) {
//
//        if (entity.getUsername() == null || (entity.getPassword() == null && entity.getActivationCode() == null)) {
//            return new HashMap<String, String>() {{
//                put("status", "error");
//                put("message", "input missing");
//            }};
//        }
//
//        Users result = userRepository.findByUsername(entity.getUsername());
//
//
//        if (result == null) {
//            return new HashMap<String, String>() {{
//                put("status", "error");
//                put("message", "username is not valid"); //mobile number is not registered in databse
//            }};
//        } else if (entity.getPassword() == null) {
//            if (result.isLock() == false && (result.getActivationSmsCode().equals(entity.getActivationCode()))) {
//
//
//                return new HashMap<String, String>() {{
//                    put("status", "success");
//                    put("message", new TokenCreator().create(entity.getUsername()));
//                }};
//            }
//        } else if (entity.getActivationCode() == null) {
//            if (new BCryptPasswordEncoder().matches(entity.getPassword(), result.getPassword()) && result.isLock() == false) {
//
//                return new HashMap<String, String>() {{
//                    put("status", "success");
//                    put("message", new TokenCreator().create(entity.getUsername()));
//                }};
//            }
//        } else if (entity.getActivationCode() != null && entity.getPassword() != null) {
//            if (result.isLock() == false && (result.getActivationSmsCode().equals(entity.getActivationCode()))) {
//                result.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));
//
//                userRepository.save(result);
//                return new HashMap<String, String>() {{
//                    put("status", "success");
//                    put("message", new TokenCreator().create(entity.getUsername()));
//                }};
//            }
//        }
//
//        return new HashMap<String, String>() {{
//            put("status", "error");
//            put("message", "data is not valid"); //user name is correct and password or activation code is not valid
//        }};
//
//    }




    public Users getById(Long id) {
        return userRepository.findById(id).get();
    }

    public Users getByUsername (String username)
    {
        return userRepository.findByUsername(username);
    }

    public Users add(Users newUsers) {
        if (newUsers.getPassword() != null) {
            newUsers.setPassword(bCryptPasswordEncoder.encode(newUsers.getPassword()));
        }
        Users addedUser = userRepository.save(newUsers);
        return addedUser;
    }


    public Users update(Users newUsers) {

        return userRepository.save(newUsers);
    }


    public List<Users> getAll() {
        return userRepository.findAll();
    }


    public Users enableUserById(long id) {
        Users u = userRepository.findById(id).get();
        u.setActive(true);
        return userRepository.save(u);
    }

    public Users disableUserById(long id) {
        Users u = userRepository.findById(id).get();
        u.setActive(false);
        return userRepository.save(u);
    }


    public Users checkIfMobileNumberIsRegistered(Users user) {
        return userRepository.findByUsername(user.getUsername());
    }



    public String checkUsersToken(String token) {
        TokenCreator tokenCreator = new TokenCreator();
        String[] tokenArray = token.split("____");
        if (tokenCreator.create(tokenArray[1]).equals(token)) {
            return tokenArray[1];
        }
        return "token is not valid";

    }



    public Users changePassword(UsersDTO user) {
        String username = user.getToken().split("____")[1];
        if (!new TokenCreator().create(username).equals(user.getToken())) {
            return null;
        }
        Users currentUser = userRepository.findByUsername(username);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(currentUser);

    }


}