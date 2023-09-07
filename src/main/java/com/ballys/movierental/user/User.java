package com.ballys.movierental.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class User {

    private Long id;
    @NotEmpty
    private String email;
    @NotEmpty
    private String name;
}
