package com.wiryaimd.searchapi.controller;

import com.wiryaimd.searchapi.dto.req.AuthReqDto;
import com.wiryaimd.searchapi.dto.res.AuthResDto;
import com.wiryaimd.searchapi.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/auth")
    public ResponseEntity<AuthResDto> auth(@RequestBody AuthReqDto authReqDto){

        return ResponseEntity.ok(null);
    }

}
