package com.sage.services;

import com.sage.domain.Invoice;

/**
 * Created by jonatannietoa on 29/3/17.
 */
public interface InvoiceService {
    Iterable<Invoice> listAllInvoices();

    Invoice save(Invoice invoice);

    Invoice getInvoiceById(Integer id);
}
