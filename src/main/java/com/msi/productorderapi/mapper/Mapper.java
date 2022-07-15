package com.msi.productorderapi.mapper;

import com.msi.productorderapi.api.OrderApi;
import com.msi.productorderapi.api.UserOrderListApi;
import com.msi.productorderapi.model.Order;
import com.msi.productorderapi.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapper {
    public List<OrderApi> fromProductOrder(List<Order> orderList){
        return orderList.stream().map(order->
                OrderApi.builder()
                        .productName(order.getProduct().getProductName())
                        .description(order.getProduct().getDescription())
                        .model(order.getProduct().getModel())
                        .status(order.getStatus())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public UserOrderListApi fromUserOrder(List<OrderApi> orderList, User user){
        return UserOrderListApi.builder()
                .UserName(user.getFirstName()+" "+user.getLastName())
                .orderApiList(orderList)
                .build();
    }
}
