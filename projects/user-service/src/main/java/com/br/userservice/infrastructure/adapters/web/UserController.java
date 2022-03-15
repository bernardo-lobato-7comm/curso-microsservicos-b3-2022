package com.br.userservice.infrastructure.adapters.web;

import com.br.userservice.application.domain.User;
import com.br.userservice.application.port.inbound.UserInbound;
import com.br.userservice.infrastructure.adapters.web.dto.UserCreatedRequest;
import com.br.userservice.infrastructure.adapters.web.dto.UserCreatedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserInbound userInbound;

    @Autowired
    public UserController(UserInbound userInbound) {
        this.userInbound = userInbound;
    }

    @PostMapping
    UserCreatedResponse createUser(@RequestBody final UserCreatedRequest userCreatedRequest) {
        String userId = userInbound.createUser(userCreatedRequest.getEmail());
        return new UserCreatedResponse(userId);
    }

    @GetMapping("/{id}")
    User findById(@PathVariable final String id) {
        final User user = userInbound.findById(id).get();
        return user;
    }

    @GetMapping
    List<User> findAll(){
        return userInbound.findAll();
    }

    @DeleteMapping(value = "/{id}")
    void deleteUser(@PathVariable final String id) {
        userInbound.deleteUser(id);
    }
}
