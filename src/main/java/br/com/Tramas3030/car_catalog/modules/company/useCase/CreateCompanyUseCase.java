package br.com.Tramas3030.car_catalog.modules.company.useCase;

import br.com.Tramas3030.car_catalog.exceptions.CompanyFoundException;
import br.com.Tramas3030.car_catalog.exceptions.UserFoundException;
import br.com.Tramas3030.car_catalog.modules.company.entities.CompanyEntity;
import br.com.Tramas3030.car_catalog.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository.findByNameOrEmail(companyEntity.getName(), companyEntity.getEmail())
                .ifPresent(user -> {
                    throw new CompanyFoundException();
                });

        var encryptedPassword = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(encryptedPassword);

        return this.companyRepository.save(companyEntity);
    }

}
