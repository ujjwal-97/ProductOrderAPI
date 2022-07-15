package com.msi.productorderapi.controller;

import com.msi.productorderapi.api.UserOrderListApi;
import com.msi.productorderapi.model.User;
import com.msi.productorderapi.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/product/order")
public class Controller {

    @Autowired
    Service service;

    @GetMapping("/user/fetch")
    public ResponseEntity<?> getUserName(){
        List<User> userList= service.getUsers();
        if(!CollectionUtils.isEmpty(userList)){
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Integer userId){
        User user = service.getUserById(userId);
        if(Objects.nonNull(user)){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/order/{userId}")
    public ResponseEntity<?> getUserOrder(@PathVariable Integer userId){
        UserOrderListApi userOrderListApi = service.getOrderListForUser(userId);
        if(Objects.nonNull(userOrderListApi)){
            return new ResponseEntity<>(userOrderListApi, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
