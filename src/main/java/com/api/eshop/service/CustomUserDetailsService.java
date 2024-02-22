package com.api.eshop.service;


import com.api.eshop.domain.Users;
import com.api.eshop.exceptions.ApiExceptionMessageParser;
import com.api.eshop.exceptions.ApiRequestException;
import com.api.eshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username);
        if (users == null)
            new ApiRequestException("exception accured : " + ApiExceptionMessageParser.getErrorReasonByExceptionMessage("user not found"));
        return users;

    }


    @Transactional
    public Users loadUserById(long id) {
        Users users = usersRepository.findById(id).get();
        if (users == null)
            new ApiRequestException("exception accured : " + ApiExceptionMessageParser.getErrorReasonByExceptionMessage("user not found"));
        return users;
    }



}
