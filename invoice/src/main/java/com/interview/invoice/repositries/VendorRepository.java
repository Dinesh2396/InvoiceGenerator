package com.interview.invoice.repositries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.interview.invoice.model.Vendor;

@Repository
public interface VendorRepository extends CrudRepository<Vendor,Integer> {

}
