package com.interview.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.interview.invoice.beans.InvoiceWrapper;
import com.interview.invoice.exception.RecordNotFoundException;
import com.interview.invoice.model.Invoice;
import com.interview.invoice.service.InvoiceService;

@Controller
public class InvoiceController {
	
	@Autowired
	private InvoiceService InvoiceService;
	
	
	@GetMapping("/getAllInvoice")
	public ResponseEntity<Iterable<Invoice>> getAllInvoice() throws RecordNotFoundException
	{
		Iterable<Invoice> allInvoiceData=InvoiceService.getAllInvoice();
		return ResponseEntity.ok(allInvoiceData);
		
	}
	
	@PostMapping("/generateInvoice")
	public ResponseEntity<InvoiceWrapper> saveInvoiceDetails(@RequestBody InvoiceWrapper invoiceWrapper)
	{
		invoiceWrapper=InvoiceService.saveInvoiceDetails(invoiceWrapper);
		return ResponseEntity.ok(invoiceWrapper);
	}
	
	@GetMapping("/getInvoice/{id}")
	public ResponseEntity<InvoiceWrapper> getInvoiceDetailsById(@PathVariable int id) throws RecordNotFoundException
	{
		InvoiceWrapper invoiceWrapper=InvoiceService.getInvoiceDetailsByID(id);
		return ResponseEntity.ok(invoiceWrapper);
		
	}
	@PutMapping("/updateInvoice")
	public ResponseEntity<InvoiceWrapper> updateInvoiceDetails(@RequestBody InvoiceWrapper invoiceWrapper) throws RecordNotFoundException
	{
		invoiceWrapper=InvoiceService.updateInvoiceDetails(invoiceWrapper);
		return ResponseEntity.ok(invoiceWrapper);
	}
}
