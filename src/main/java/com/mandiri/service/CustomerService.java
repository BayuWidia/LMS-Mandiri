package com.mandiri.service;

import com.mandiri.model.Customer;

public interface CustomerService {
	
	public void saveCustomer(Customer customer);
	public Customer findCustomerByCif(Long cif);

}
