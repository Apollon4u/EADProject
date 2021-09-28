package com.example.stockmicroservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String country = "Kazakhstan";
    private Long cityId;
    private String city;
    private String street;
    private String house;

    public String concatAddressAsString() {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotBlank(this.city))
            sb.append(city);

        if (StringUtils.isNotBlank(this.street)) {
            sb.append(", ").append(street);
        }

        if (StringUtils.isNotBlank(this.house)) {
            sb.append(", ").append(house);
        }
        
        return sb.toString();
    }
}
