package com.mandiri.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.mandiri.model.TCpo;
import com.mandiri.model.TCustomerResponse;
import com.mandiri.model.TOffer;
import com.mandiri.repository.TCpoRepository;
import com.mandiri.repository.TCustomerResponseRepository;
import com.mandiri.util.GenerateUUID;

@Service
public class ResponseService {

	@Autowired
	TCpoRepository tCpoRepo;
	@Autowired
	TCustomerResponseRepository tcustomerResponseRepo;
	
	@Transactional
	public Pair<Integer, String> saveCustomer(String cpoid, TCustomerResponse blankResponse){
		//GET selected tCpo records
		TCpo cpo = new TCpo();
		cpo = tCpoRepo.findbyId(blankResponse.getTOffer().getId());
		
		//SET tcpo records to new offer
		TOffer newOffer = new TOffer();
		String id_newOffer = GenerateUUID.getUUID();
		blankResponse.getTOffer().setId(id_newOffer);
		newOffer.setId(id_newOffer);
		newOffer.setArea(cpo.getArea());
		newOffer.setBranchCategory(cpo.getBranchCategory());
		newOffer.setBranchProduct(cpo.getBranchProduct());
		newOffer.setChannel(cpo.getChannel());
		newOffer.setCreatedon(cpo.getCreatedon());
		newOffer.setExpirydate(cpo.getExpirydate());
		newOffer.setIncome(cpo.getIncome());
		newOffer.setIndicativeLimit(cpo.getIndicativeLimit());
		newOffer.setIshunter(cpo.getIshunter());
		newOffer.setModelId(cpo.getModelId());
		newOffer.setModifiedon(cpo.getModifiedon());
		newOffer.setNominal(cpo.getNominal());
		newOffer.setOfferdate(new Timestamp(System.currentTimeMillis()));
		newOffer.setProductId(cpo.getProductId());
		newOffer.setProgram(cpo.getProgram());
		newOffer.setRac(cpo.getRac());
		newOffer.setRegion(cpo.getRegion());
		newOffer.setScript(cpo.getScript());
		newOffer.setSequence(cpo.getSequence());
		newOffer.setSourceType(cpo.getSourceType());
		newOffer.setStatus(blankResponse.getResponseResult());
		newOffer.setTCpi(cpo.getTCpi());
		//Save single customer response
		List<TCustomerResponse> listResponse = new ArrayList<TCustomerResponse>();
		newOffer.setTCustomerResponses(listResponse);
		newOffer.setUserprofile1(blankResponse.getUserprofile1());
		
		 try {
			 tCpoRepo.setFlagTcpo(cpoid);
			 tcustomerResponseRepo.save(blankResponse);
		  } catch (Exception ex) {
		    // trigger rollback programmatically
		    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		    return Pair.of(1,"Tangggapan tidak berhasil disimpan");
		  }
		
		return Pair.of(0,"Tanggapan berhasil disimpan");
	}
}
