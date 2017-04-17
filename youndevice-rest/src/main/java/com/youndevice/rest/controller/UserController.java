package com.youndevice.rest.controller;

import com.youndevice.domain.User;
import com.youndevice.rest.dto.ApiResponseDTO;
import com.youndevice.rest.dto.UserDTO;
import com.youndevice.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController extends BaseController {


    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public User getDetails(@RequestParam(value = "name", defaultValue = "Usser") String name,
                           @RequestParam(value = "id", defaultValue = "1") String id) {
        return new User(id, name);
    }


    @RequestMapping("/admin")
    public User getAdminDetails(@RequestParam(value = "name", defaultValue = "admin") String name,
                                @RequestParam(value = "id", defaultValue = "1") String id) {
        return new User(id, name);
    }

    @RequestMapping(value = "/register",produces = MediaType.APPLICATION_JSON_VALUE , consumes =MediaType.APPLICATION_JSON_VALUE )
    public ApiResponseDTO register(@Validated @RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);

    }
}