package com.github.lateralthoughts.repository;

import com.github.lateralthoughts.config.TestConfiguration;
import com.github.lateralthoughts.domain.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class CompaniesIT {

    @Inject
    private CompaniesRepository companiesRepository;

    @Test
    public void should_insert_a_company() {
        Company company = company("Google Inc.", "Mountain View, CA", "bizness@google.com");
        companiesRepository.save(company);

        assertThat(companiesRepository.findAll()).hasSize(1);
    }

    @Test
    public void should_delete_a_company() {
        Company savedCompany = companiesRepository.save(company("Google Inc.", "Mountain View, CA", "bizness@google.com"));
        companiesRepository.delete(savedCompany);

        assertThat(companiesRepository.findAll()).hasSize(0);
    }

    @Test
    public void should_update_a_company() {
        Company savedCompany = companiesRepository.save(company("Google Inc.", "Mountain View, CA", "bizness@google.com"));

        savedCompany.setName("Github");
        savedCompany.setAddress("Cherbourg, France");

        companiesRepository.save(savedCompany);

        assertThat(companiesRepository.findAll()).hasSize(1);
        assertThat(companiesRepository.findByName("Github").getAddress()).isEqualTo("Cherbourg, France");
    }

    private Company company(String name, String address, String contact) {
        return new Company(name, address, contact);
    }

}
