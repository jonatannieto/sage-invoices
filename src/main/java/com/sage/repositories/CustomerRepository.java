package com.sage.repositories;

import com.sage.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jonatannietoa on 29/3/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer>{}
