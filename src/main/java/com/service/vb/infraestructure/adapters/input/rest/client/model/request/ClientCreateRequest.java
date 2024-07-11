package com.service.vb.infraestructure.adapters.input.rest.client.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientCreateRequest {

    @NotBlank(message = "Field firstname cannot be empty or null.")
    private String firstname;

    @NotBlank(message = "Field lastname cannot be empty or null.")
    private String lastname;

    @NotBlank(message = "Field email cannot be empty or null.")
    private String  email;

    @NotBlank(message = "Field address cannot be empty or null.")
    private  String address;
}
