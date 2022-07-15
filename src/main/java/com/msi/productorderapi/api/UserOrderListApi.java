package com.msi.productorderapi.api;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserOrderListApi {
    String UserName;
    List<OrderApi> orderApiList;
}
