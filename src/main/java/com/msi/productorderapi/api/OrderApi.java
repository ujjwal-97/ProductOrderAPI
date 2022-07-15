package com.msi.productorderapi.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderApi {
    String productName;
    String status;
    String model;
    String description;
}
