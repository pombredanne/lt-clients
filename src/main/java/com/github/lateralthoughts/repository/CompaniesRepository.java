package com.github.lateralthoughts.repository;

import com.github.lateralthoughts.domain.Company;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CompaniesRepository extends PagingAndSortingRepository<Company, Long> {

    Company findByName(String name);
}
