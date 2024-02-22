package com.api.eshop.controller;

import com.api.eshop.domain.Users;
import com.api.eshop.exceptions.ApiExceptionMessageParser;
import com.api.eshop.exceptions.ApiRequestException;
import com.api.eshop.payload.JwtLoginSuccessResponse;
import com.api.eshop.payload.LoginRequest;
import com.api.eshop.service.utilities.ErrorsMaps;
import com.api.eshop.service.utilities.FileStorageService;
import com.api.eshop.security.JwtTokenProvider;
import com.api.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private ErrorsMaps errorsMaps;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private FileStorageService fileStorageService;











    @PostMapping("register")
    @CrossOrigin("*")
    public ResponseEntity add( @RequestBody Users user) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Users userData = service.getByUsername(user.getUsername());
            if(userData!=null)
            {
               return new ResponseEntity(new Users() , HttpStatus.OK);
            }
            user.setRole("admin");
            Users addedUser = service.add(user);
            addedUser.setPassword("*");
            return new ResponseEntity<Users>(addedUser, HttpStatus.CREATED);
        } catch (Exception exc) {
            throw new ApiRequestException(ApiExceptionMessageParser.getErrorReasonByExceptionMessage(exc.getMessage()));
        }
    }

    @PostMapping("login")
    @CrossOrigin("*")
    public ResponseEntity authenticateUser( @RequestBody LoginRequest loginRequest) {


        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = "Bearer " + jwtTokenProvider.generateToken(authentication);
            return new ResponseEntity(new JwtLoginSuccessResponse(true, jwt), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity("you can not login" , HttpStatus.OK);
        }

    }





}
