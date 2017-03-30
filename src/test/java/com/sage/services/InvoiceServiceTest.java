package com.sage.services;

import com.sage.domain.Customer;
import com.sage.domain.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceServiceTest {
    private InvoiceService invoiceService;
    private Customer customer;
    private Invoice invoice;

    @Autowired
    public void setProductRepository(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Before
    public void setUp(){
        //setup customer
        customer = new Customer();
        customer.setName("Customer 1");

        //setup product
        invoice = new Invoice();
        invoice.setDescription("Invoice Test Example");
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        invoice.setDate(date);
        invoice.setAmount(500.75);
        invoice.setCustomer(customer);
    }

    @Test
    @Transactional
    public void testSaveInvoice(){
        //save product, verify has ID value after save
        assertNull(invoice.getId()); //null before save
        invoiceService.save(invoice);
        assertNotNull(invoice.getId()); //not null after save
    }

    @Test
    public void testModifyInvoice(){
        //fetch from DB
        Invoice fetchedInvoice = invoiceService.listAllInvoices().iterator().next();

        //update description and save
        fetchedInvoice.setDescription("New Description");
        invoiceService.save(fetchedInvoice);

        //get from DB, should be updated
        Invoice fetchedUpdatedProduct = invoiceService.getInvoiceById(fetchedInvoice.getId());
        assertEquals(fetchedInvoice.getDescription(), fetchedUpdatedProduct.getDescription());
    }
}
