package com.user.managment.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UserDto {
    @Schema(
            description = "Email address of the User",example = "romansvyshch@gmail.com"
    )
    @NotEmpty(message = "email can`t be empty")
    @Email(message = "email address should be a valid name")
    private String email;

    @Schema(
            description = "Name of the User",example = "Jon"
    )
    @NotEmpty(message = "First Name can`t be empty")
    @Size(min = 3,max = 30)
    private String firstName;

    @Schema(
            description = "Last Name of the Customer",example = "Doe"
    )
    @NotEmpty(message = "Last Name can`t be empty")
    @Size(min = 3,max = 30)
    private String lastName;

    @NotNull
    @Past
    @Schema(
            description = "Date of birth users",example = "2020-01-01"
    )
    private LocalDate birthDate;

    @Schema(
            description = " address of the user",example = "Bohuna 9 Lviv"
    )
    private String address;

    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile Number must be 10 digits.Like '0996681573'")
    private String phoneNumber;


}


