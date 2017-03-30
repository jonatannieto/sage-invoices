package com.sage.controllers;

import com.sage.domain.Invoice;
import com.sage.services.CustomerService;
import com.sage.services.InvoiceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jonatannietoa on 29/3/17.
 */
@Controller
public class InvoiceController {

    private InvoiceService invoiceService;
    private CustomerService customerService;
    private Logger log = Logger.getLogger(InvoiceController.class);

    @Autowired
    public InvoiceController(InvoiceService invoiceService, CustomerService customerService) {
        this.invoiceService = invoiceService;
        this.customerService = customerService;
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("invoices", invoiceService.listAllInvoices());
        log.info("Returning invoices.");
        return "invoices";
    }

    @RequestMapping("invoice/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("invoice", invoiceService.getInvoiceById(id));
        return "invoiceshow";
    }

    @RequestMapping(value = "invoice/new")
    public String newInvoice(Model model){
        model.addAttribute("invoice", new Invoice());
        model.addAttribute("customers", customerService.listAllCustomer());
        return "invoiceform";
    }

    @RequestMapping("invoice/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("invoice", invoiceService.getInvoiceById(id));
        model.addAttribute("customers", customerService.listAllCustomer());
        return "invoicemodify";
    }

    @RequestMapping(value = "invoice", method = RequestMethod.POST)
    public String create(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoice/" + invoice.getId();
    }
}
