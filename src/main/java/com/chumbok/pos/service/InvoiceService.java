package com.chumbok.pos.service;

import com.chumbok.pos.dto.InvoiceDTO;
import com.chumbok.pos.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getAllInvoices();

    Invoice getInvoice(long invoiceId);

    Invoice createInvoice(InvoiceDTO invoiceDTO);

    void updateInvoice(Invoice invoice);

    void deleteInvoice(long invoiceId);
}