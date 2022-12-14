package com.wiryaimd.searchapi.services;

import com.wiryaimd.searchapi.dto.req.AuthReqDto;
import com.wiryaimd.searchapi.model.UserModel;
import com.wiryaimd.searchapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> allUsers(){
        return userRepository.findAll();
    }

    public UserModel findUser(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
