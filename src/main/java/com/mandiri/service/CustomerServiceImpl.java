package com.mandiri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandiri.model.Customer;
import com.mandiri.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer findCustomerByCif(Long cif) {
		// TODO Auto-generated method stub
		
		return customerRepository.findCustomerByCif(cif);
	}

}
