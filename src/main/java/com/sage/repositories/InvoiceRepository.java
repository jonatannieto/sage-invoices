package com.sage.repositories;

import com.sage.domain.Invoice;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jonatannietoa on 29/3/17.
 */
public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{}
