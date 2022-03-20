# InvoiceGenerator

Backend Changes for Invoice Generator Application.

**Used Technology : Java 1.8, Spring Boot with Hibernate, PGSQL
**

Created as per MVC pattern.

**Constraints and API details:**

API's created for Create,Update and view of Invoice.



**Samle Input JSON body:
**
{
    "id" :1,
    "vendor": {
        "id":1,
        "vendorGSTIN": "687",
        "address": "No 4",
        "city": "Bangalore",
        "state": "Karnataka",
        "country": "India",
        "companyname": "Texas1"
    },
    "customer": {
        "id": 1,
        "clientname": "Girish",
        "clientGSTIN": "45",
        "address": "No 7",
        "city": "Chennai",
        "state": "Tamilnadu",
        "country": "India"
    },
    "product": [
        {
            "quantity": 1,
            "sgst": 12,
            "cgst": 12,
            "cess": 13,
            "amount": 120,
            "id": 1,
            "productname": "Computer"
        },
        {
            "quantity": 2,
            "sgst": 12,
            "cgst": 12,
            "cess": 13,
            "amount": 120,
            "id": 1,
            "productname": "Adapter" 
        }
    ],
    "dueDate": "2022-04-01T15:53:26.854+00:00"
}

**Database Creation and Updation Queries:
**

Customer Details:

  create table customer (
       id int4 not null,
        address varchar(255),
        city varchar(255),
        clientgstin varchar(255) not null,
        clientname varchar(255) not null,
        country varchar(255),
        state varchar(255),
        primary key (id)
    )
    
Vendor Details:

create table vendor (
       id int4 not null,
        companyname varchar(255) not null,
        address varchar(255),
        city varchar(255),
        country varchar(255),
        state varchar(255),
        vendorgstin varchar(255) not null,
        primary key (id)
    )

Product Details:
  
    create table product (
       id int4 not null,
        productname varchar(255) not null,
        amount int4 not null,
        cess int4 not null,
        cgst int4 not null,
        quantity int4 not null,
        sgst int4 not null,
        invoice_id int4,
        primary key (id)
    )
 
 Invoice Details:
 
   create table invoice (
       id int4 not null,
        due_date timestamp,
        invoice_date timestamp,
        total int8 not null,
        customer_id int4,
        vendor_id int4,
        primary key (id)
    )
    
    
  Insert and Select Queries example and operations:
  
  1) insert into vendor(companyname, address, city, country, state, vendorgstin, id)values(?, ?, ?, ?, ?, ?, ?)
  2) insert into product(productname, amount, cess, cgst, invoice_id, quantity, sgst, id)values(?, ?, ?, ?, ?, ?, ?, ?)
  3) insert into invoice(customer_id, due_date, invoice_date, total, vendor_id, id) values(?, ?, ?, ?, ?, ?)
  4) insert into customer(address, city, clientgstin, clientname, country, state, id) values(?, ?, ?, ?, ?, ?, ?)


