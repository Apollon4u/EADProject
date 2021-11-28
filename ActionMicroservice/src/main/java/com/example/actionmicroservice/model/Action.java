package com.example.actionmicroservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "action")
public class Action {
    @Id
    @SequenceGenerator(name = "action-sequence", sequenceName = "action_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "action-sequence")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "method_name")
    private String methodName;
    private String info;
}
