package com.example.stockmicroservice.model.dto;

import com.example.stockmicroservice.model.entity.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class StockDto {
    private Long id;
    private Address address;
    private Boolean active;
    private String storeName;
    private Boolean pickupAvailable;
}
