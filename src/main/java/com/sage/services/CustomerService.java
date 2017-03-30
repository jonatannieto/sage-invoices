package com.sage.services;

import com.sage.domain.Customer;

/**
 * Created by jonatannietoa on 29/3/17.
 */
public interface CustomerService {
    Iterable<Customer> listAllCustomer();

    Customer save(Customer customer);

    Customer getCustomerById(Integer id);
}
