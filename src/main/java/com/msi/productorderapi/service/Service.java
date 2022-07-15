package com.msi.productorderapi.service;

import com.msi.productorderapi.api.OrderApi;
import com.msi.productorderapi.api.UserOrderListApi;
import com.msi.productorderapi.mapper.Mapper;
import com.msi.productorderapi.model.User;
import com.msi.productorderapi.repository.OrderRepository;
import com.msi.productorderapi.repository.ProductRepository;
import com.msi.productorderapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
@RequiredArgsConstructor
public class Service {
    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Mapper mapper;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Integer userId){
        return userRepository.findUserById(userId);
    }

    public UserOrderListApi getOrderListForUser(Integer userId){
        User user = userRepository.findUserById(userId);
        List<OrderApi> orderApiList = mapper.fromProductOrder(user.getOrderList());
        return mapper.fromUserOrder(orderApiList, user);
    }

}
