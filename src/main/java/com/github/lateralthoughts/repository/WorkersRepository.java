package com.github.lateralthoughts.repository;

import com.github.lateralthoughts.domain.Worker;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

@RestResource
public interface WorkersRepository extends PagingAndSortingRepository<Worker, Long> {

    Worker findByLastName(String lastName);
}
