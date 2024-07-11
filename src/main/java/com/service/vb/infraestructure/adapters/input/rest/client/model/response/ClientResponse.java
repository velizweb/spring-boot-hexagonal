package com.service.vb.infraestructure.adapters.input.rest.client.model.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String  email;
    private  String address;
}
