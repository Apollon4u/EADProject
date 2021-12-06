package com.example.kitchenmicroservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "kitchen")
@NoArgsConstructor
public class Kitchen {

    @Id
    @SequenceGenerator(name = "kitchen-sequence", sequenceName = "kitchen_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "kitchen-sequence")
    private Long id;

    @ApiModelProperty("Name of kitchen")
    private String name;

    @NotNull
    @Column(name = "email")
    @ApiModelProperty("Email of kitchen's manager")
    private String email;

    @Column(name = "phone_number")
    @ApiModelProperty("Phone number of kitchen's manager")
    private String phoneNumber;

    @ApiModelProperty("Address of kitchen")
    private String address;

    @Column(name = "iin_bin")
    @ApiModelProperty("IIN/BIN of kitchen")
    private String iinBin;
}
