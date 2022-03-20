package com.interview.invoice.repositries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.interview.invoice.model.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice,Integer> {

}
