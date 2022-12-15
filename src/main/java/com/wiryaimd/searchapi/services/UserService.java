package com.wiryaimd.searchapi.services;

import com.wiryaimd.searchapi.dto.req.AuthReqDto;
import com.wiryaimd.searchapi.dto.req.UserReqDto;
import com.wiryaimd.searchapi.model.RoleModel;
import com.wiryaimd.searchapi.model.UserModel;
import com.wiryaimd.searchapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    public List<UserModel> allUsers(){
        return userRepository.findAll();
    }

    public UserModel saveUser(UserReqDto userReqDto){
        List<RoleModel> roles = Arrays.stream(userReqDto.roles().split(",")).map(new Function<String, RoleModel>() {
            @Override
            public RoleModel apply(String s) {
                return new RoleModel(new SimpleGrantedAuthority(s));
            }
        }).toList();

        UserModel userModel = new UserModel(
                UUID.randomUUID(),
                userReqDto.username(),
                passwordEncoder.encode(userReqDto.password()),
                roles
        );

        return userRepository.save(userModel);
    }

    public UserModel findUser(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
