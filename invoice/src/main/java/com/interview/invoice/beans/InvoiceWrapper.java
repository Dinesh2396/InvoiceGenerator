package com.interview.invoice.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.interview.invoice.model.Customer;
import com.interview.invoice.model.Product;
import com.interview.invoice.model.Vendor;

public class InvoiceWrapper {
	private int id;
	private Vendor vendor;
	private Customer customer;
	private List<Product> product;
	private long total;
	private Date invoiceDate;
	private Date dueDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date date) {
		this.invoiceDate = date;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date date) {
		this.dueDate = date;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
}
