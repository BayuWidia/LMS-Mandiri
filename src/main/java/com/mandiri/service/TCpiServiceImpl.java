package com.mandiri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandiri.model.TCpi;
//import com.mandiri.model.Customer;
import com.mandiri.repository.TCpiRepository;

@Service("customerService")
public class TCpiServiceImpl implements TCpiService {

	@Autowired
	private TCpiRepository tCpiRepository;

//	@Override
//	public void saveCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//
//	}
//
	@Override
	public TCpi findTCpiByCif(String cif) {
		// TODO Auto-generated method stub
		
		return tCpiRepository.findbyCif(cif);
	}

}
