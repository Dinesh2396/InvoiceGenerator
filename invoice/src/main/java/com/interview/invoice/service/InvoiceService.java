package com.interview.invoice.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.invoice.beans.InvoiceWrapper;
import com.interview.invoice.exception.RecordNotFoundException;
import com.interview.invoice.model.Product;
import com.interview.invoice.model.Vendor;
import com.interview.invoice.model.Customer;
import com.interview.invoice.model.Invoice;
import com.interview.invoice.repositries.InvoiceRepository;
import com.interview.invoice.repositries.VendorRepository;
import com.interview.invoice.repositries.CustomerRepository;
import com.interview.invoice.repositries.ProductRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository InvoiceRepository;;
	@Autowired
	private VendorRepository VendorRepository;
	@Autowired
	private CustomerRepository CustomerRepository;
	@Autowired
	private ProductRepository ProductRepository;

	public InvoiceWrapper saveInvoiceDetails(InvoiceWrapper invoiceWrapper) {
		Invoice newInvoice = new Invoice();
		newInvoice.setId(invoiceWrapper.getId());
		Vendor vendor = invoiceWrapper.getVendor();
		VendorRepository.save(vendor);
		newInvoice.setVendor(vendor);
		Customer customer = invoiceWrapper.getCustomer();
		CustomerRepository.save(customer);
		newInvoice.setCustomer(customer);
		List<Product> products=invoiceWrapper.getProduct(); 
		long total=0;
		for(Product product:products) { 
			long amount=product.getAmount()*product.getQuantity();
			 total+=amount; 
		  }
		newInvoice.setTotal(total);
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		newInvoice.setInvoiceDate(timestamp);
		newInvoice.setDueDate(invoiceWrapper.getDueDate());
		InvoiceRepository.save(newInvoice);
		for(Product product:products) { 
			  product.setInvoice(newInvoice);
			  ProductRepository.save(product); 
		  }
		return invoiceWrapper;
	}

	public InvoiceWrapper getInvoiceDetailsByID(Integer id) throws RecordNotFoundException {
		InvoiceWrapper invoiceWrapper = null;
		Optional<Invoice> invoiceData = InvoiceRepository.findById(id);
		if (invoiceData.isPresent()) {
			invoiceWrapper = new InvoiceWrapper();
			Invoice Invoice = invoiceData.get();
			invoiceWrapper.setId(Invoice.getId());
			invoiceWrapper.setCustomer(Invoice.getCustomer());
			invoiceWrapper.setVendor(Invoice.getVendor());
			invoiceWrapper.setProduct(Invoice.getProducts());
			invoiceWrapper.setTotal(Invoice.getTotal());
			invoiceWrapper.setDueDate(Invoice.getDueDate());
			invoiceWrapper.setInvoiceDate(Invoice.getInvoiceDate());

		} else {
			throw new RecordNotFoundException("Invoice Details not found");
		}
		return invoiceWrapper;
	}

	public InvoiceWrapper updateInvoiceDetails(InvoiceWrapper invoiceWrapper) throws RecordNotFoundException {

		Optional<Invoice> invoiceData = InvoiceRepository.findById((int) invoiceWrapper.getId());
		if (invoiceData.isPresent()) {
			// update product details
			Invoice newInvoice = new Invoice();
			newInvoice.setId(invoiceWrapper.getId());
			Vendor vendor = invoiceWrapper.getVendor();
			VendorRepository.save(vendor);
			newInvoice.setVendor(vendor);
			Customer customer = invoiceWrapper.getCustomer();
			CustomerRepository.save(customer);
			newInvoice.setCustomer(customer);		
			List<Product> products=invoiceWrapper.getProduct(); 
			long total=0;
			for(Product product:products) { 
				long amount=product.getAmount()*product.getQuantity();
				 total+=amount; 
			  }
			newInvoice.setTotal(total);
			Date date = new Date();
			Timestamp timestamp = new Timestamp(date.getTime());
			newInvoice.setInvoiceDate(timestamp);
			newInvoice.setDueDate(invoiceWrapper.getDueDate());
			InvoiceRepository.save(newInvoice);
			for(Product product:products) { 
				  product.setInvoice(newInvoice);
				  ProductRepository.save(product); 
			 }
			return invoiceWrapper;
		} else {
			throw new RecordNotFoundException("Invoice Details not found");
		}

	}

	public Iterable<Invoice> getAllInvoice() {
		Iterable<Invoice> invoiceData = InvoiceRepository.findAll();
		return invoiceData;
	}

}
