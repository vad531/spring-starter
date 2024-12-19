package org.example.service;

import lombok.*;
import org.example.database.repository.CompanyRepository;
import org.example.dto.CompanyReadDto;
import org.example.listener.AccessType;
import org.example.listener.EntityEvent;
import org.example.listener.PostEntityEvent;
import org.example.listener.PreEntityEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Setter
@ToString
public class CompanyService {
    @Value("${company.name:TechCorp}")
    private String companyName;
    @Value("${company.size:500}")
    private int companySize;

    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CompanyService(CompanyRepository companyRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.companyRepository = companyRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id) {
        applicationEventPublisher.publishEvent(new PreEntityEvent(this, AccessType.READ));

        Optional<CompanyReadDto> result = companyRepository.findById(id)
                .map(entity -> new CompanyReadDto(entity.id()));

        applicationEventPublisher.publishEvent(new PostEntityEvent(this, AccessType.READ));

        return result;
    }
}