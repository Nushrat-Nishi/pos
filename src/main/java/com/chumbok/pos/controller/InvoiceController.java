package com.chumbok.pos.controller;

import com.chumbok.pos.dto.InvoiceDTO;
import com.chumbok.pos.dto.PersistedObjId;
import com.chumbok.pos.entity.Invoice;
import com.chumbok.pos.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Invoice> getInvoices() {
        List<Invoice> list = invoiceService.getAllInvoices();
        return list;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public PersistedObjId createInvoice(@RequestBody @Valid InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceService.createInvoice(invoiceDTO);
        return new PersistedObjId(invoice.getId());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable("id") Integer id) {
        Invoice invoice = invoiceService.getInvoice(id);
        return invoice;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateInvoice(@PathVariable("id") Long id, @RequestBody @Valid Invoice invoice) {
        invoice.setId(id);
        invoiceService.updateInvoice(invoice);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteInvoice(@PathVariable("id") Long id) {
        invoiceService.deleteInvoice(id);
    }
}