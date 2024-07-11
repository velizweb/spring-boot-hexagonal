package com.service.vb.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    private Long id;
    private String name;
    private String address;
}
