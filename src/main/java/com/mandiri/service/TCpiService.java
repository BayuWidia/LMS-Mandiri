package com.mandiri.service;

import com.mandiri.model.TCpi;

import java.util.List;


public interface TCpiService {
	
//	public void saveCustomer(Customer customer);
	public TCpi findTCpiByCif(String cif);

	public List<TCpi> getAllTcpis();
}
