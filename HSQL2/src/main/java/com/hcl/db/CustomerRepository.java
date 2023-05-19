package com.hcl.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {}
