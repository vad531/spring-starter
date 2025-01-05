package org.example.dto;

import java.time.LocalDate;

public interface IPersonalInfo {
    String getFirstname();
    String getLastname();
    LocalDate getBirthDate();
}