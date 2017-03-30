package com.sage.bootstrap;

import com.sage.domain.Customer;
import com.sage.domain.Invoice;
import com.sage.domain.Status;
import com.sage.repositories.CustomerRepository;
import com.sage.repositories.InvoiceRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by jonatannietoa on 29/3/17.
 */
@Component
public class InvoiceLoader implements ApplicationListener<ContextRefreshedEvent> {
    private CustomerRepository customerRepository;
    private InvoiceRepository invoiceRepository;
    private Logger log = Logger.getLogger(InvoiceLoader.class);

    @Autowired
    public InvoiceLoader(InvoiceRepository invoiceRepository, CustomerRepository customerRepository) {
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Customer customer1 = new Customer();
        customer1.setName("Customer 1");
        Customer customer2 = new Customer();
        customer2.setName("Customer 2");

        customerRepository.save(customer1);
        customerRepository.save(customer2);

        customer1 = customerRepository.findAll().iterator().next();

        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        Invoice invoice1 = new Invoice(date, customer1, "Invoice example 1", 500.50, Status.PENDING);
        Invoice invoice2 = new Invoice(date, customer2, "Invoice example 2", 2500.50, Status.PAID);

        invoiceRepository.save(invoice1);
        invoiceRepository.save(invoice2);
    }
}
