package com.sage.services;

import com.sage.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    private CustomerService customerService;
    private Customer customer;

    @Autowired
    public void setProductRepository(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Before
    public void setUp(){
        //setup customer
        customer = new Customer();
        customer.setName("Customer 1");
    }

    @Test
    @Transactional
    public void testSaveCustomer(){
        //save product, verify has ID value after save
        assertNull(customer.getId()); //null before save
        customerService.save(customer);
        assertNotNull(customer.getId()); //not null after save
    }

    @Test
    public void testModifyCustomer(){
        //fetch from DB
        Customer fetchedCustomer = customerService.listAllCustomer().iterator().next();

        //update description and save
        fetchedCustomer.setName("Name Changed");
        customerService.save(fetchedCustomer);

        //get from DB, should be updated
        Customer fetchedUpdatedCustomer = customerService.getCustomerById(fetchedCustomer.getId());
        assertEquals(fetchedCustomer.getName(), fetchedUpdatedCustomer.getName());
    }
}
