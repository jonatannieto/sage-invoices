package com.sage.services.impl;

import com.sage.domain.Invoice;
import com.sage.repositories.InvoiceRepository;
import com.sage.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jonatannietoa on 29/3/17.
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Iterable<Invoice> listAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(Integer id) {
        return invoiceRepository.findOne(id);
    }
}
