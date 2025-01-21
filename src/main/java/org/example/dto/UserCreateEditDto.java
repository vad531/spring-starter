package org.example.dto;

import lombok.Value;
import org.example.database.entity.Role;

import java.time.LocalDate;

@Value
public class UserCreateEditDto {
    String name;
    LocalDate birthday;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
