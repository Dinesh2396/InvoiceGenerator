package com.interview.invoice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
		@Id
		private int id;
		@ManyToOne
		private Invoice invoice;
		@Column( nullable = false )
		private String Productname;
		@Column( nullable = false )
		private int quantity;
		private int sgst;
		private int cgst;
		private int cess;
		@Column( nullable = false )
		private int amount;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Invoice getInvoice() {
			return invoice;
		}
		public void setInvoice(Invoice invoice) {
			this.invoice = invoice;
		}
		public String getProductname() {
			return Productname;
		}
		public void setProductname(String productname) {
			Productname = productname;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getSgst() {
			return sgst;
		}
		public void setSgst(int sgst) {
			this.sgst = sgst;
		}
		public int getCgst() {
			return cgst;
		}
		public void setCgst(int cgst) {
			this.cgst = cgst;
		}
		public int getCess() {
			return cess;
		}
		public void setCess(int cess) {
			this.cess = cess;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		
		
	}