package com.interview.invoice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="invoice")
public class Invoice {
		@Id
		private int id;
		@OneToOne
		private Vendor vendor;
		@OneToOne 
		private Customer customer;
		@OneToMany(mappedBy="invoice")
		private List<Product> product;
		@Column( nullable = false )
		private long total;
		
		private Date invoiceDate;
		private Date dueDate;
	
		public List<Product> getProduct() {
			return product;
		}
		public void setProduct(List<Product> product) {
			this.product = product;
		}
		public long getTotal() {
			return total;
		}
		public void setTotal(long total) {
			this.total = total;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public Vendor getVendor() {
			return vendor;
		}
		public void setVendor(Vendor vendor) {
			this.vendor = vendor;
		}
		public List<Product> getProducts() {
			return product;
		}
		public void setProducts(List<Product> products) {
			this.product = products;
		}

		public Date getDueDate() {
			return dueDate;
		}
		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}
		public Date getInvoiceDate() {
			return invoiceDate;
		}
		public void setInvoiceDate(Date invoiceDate) {
			this.invoiceDate = invoiceDate;
		}

	}