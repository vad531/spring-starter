package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class CompanyService {
    private String companyName;
    private int companySize;

    public void findCompanyById(int id) {
        System.out.println("Выполняется поиск компании с ID: " + id);
        System.out.println("CompanyService: companyName=" + companyName + ", companySize=" + companySize);
    }
}