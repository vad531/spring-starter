package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Setter
@ToString
public class CompanyService {
    @Value("${company.name:TechCorp}")
    private String companyName;
    @Value("${company.size:500}")
    private int companySize;

    public void findCompanyById(int id) {
        System.out.println("Выполняется поиск компании с ID: " + id);
        System.out.println("CompanyService: companyName=" + companyName + ", companySize=" + companySize);
    }
}