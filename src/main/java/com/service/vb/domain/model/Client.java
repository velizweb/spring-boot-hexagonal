package com.service.vb.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long id;
    private String firstname;
    private String lastname;
    private String  email;
    private  String address;
}
