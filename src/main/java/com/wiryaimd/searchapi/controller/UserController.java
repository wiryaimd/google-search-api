package com.wiryaimd.searchapi.controller;

import com.wiryaimd.searchapi.dto.req.UserReqDto;
import com.wiryaimd.searchapi.model.UserModel;
import com.wiryaimd.searchapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping
    public ResponseEntity<List<UserModel>> all(){
        return ResponseEntity.ok(userService.allUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody UserReqDto userReqDto){
        return ResponseEntity.ok(userService.saveUser(userReqDto));
    }

}
