package com.wiryaimd.searchapi.controller;

import com.wiryaimd.searchapi.dto.req.AuthReqDto;
import com.wiryaimd.searchapi.dto.res.AuthResDto;
import com.wiryaimd.searchapi.helper.JwtHelper;
import com.wiryaimd.searchapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("/auth")
    public ResponseEntity<AuthResDto> auth(@RequestBody AuthReqDto authReqDto){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReqDto.username(), authReqDto.password()));

        long current = System.currentTimeMillis();
        return ResponseEntity.ok(new AuthResDto(
                jwtHelper.generateToken(authReqDto.username(), Map.of("roles", "free"), current),
                current
        ));
    }

}
