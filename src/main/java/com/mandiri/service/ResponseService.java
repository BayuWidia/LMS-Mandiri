package com.mandiri.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.mandiri.filter.DashboardFilter;
import com.mandiri.model.TAuditTrail;
import com.mandiri.model.TCpo;
import com.mandiri.model.TCustomerResponse;
import com.mandiri.model.TOffer;
import com.mandiri.model.Userprofile;
import com.mandiri.repository.DashboardRepository;
import com.mandiri.repository.TCpoRepository;
import com.mandiri.repository.TCustomerResponseRepository;
import com.mandiri.repository.TOfferRepository;
import com.mandiri.util.CustomeUtil;
import com.mandiri.util.GenerateUUID;

@Service
public class ResponseService {

	@Autowired
	TCpoRepository cpoRepo;
	@Autowired
	TOfferRepository tofferRepo;
	@Autowired
	TCustomerResponseRepository tcustomerResponseRepo;
	
	@Transactional
	public Pair<Integer, String> saveCustomer(TCustomerResponse blankResponse){
		
		//Set related user on action
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Userprofile createdby = new Userprofile();
		//createdby.setNip("2222222223");
		createdby.setNip(auth.getName());
		blankResponse.setUserprofile1(createdby);
	
		blankResponse.setCustomerResponseId(GenerateUUID.getUUID());
		blankResponse.setCreatedon(new Timestamp(System.currentTimeMillis()));
		
		//GET selected tCpo records
		String cpoid = blankResponse.getTOffer().getId();
		TCpo cpo = new TCpo();
		TOffer newOffer = new TOffer();
		String id_newOffer = GenerateUUID.getUUID();
		newOffer.setId(id_newOffer);
		
		if(blankResponse.getTOffer().getId() != null && blankResponse.getTOffer().getId() != ""){
			cpo = cpoRepo.findbyId(cpoid);
			
			//SET tcpo records to new offer
			newOffer.setArea(cpo.getArea());
			newOffer.setBranchCategory(cpo.getBranchCategory());
			newOffer.setBranchProduct(cpo.getBranchProduct());
			newOffer.setChannel(cpo.getChannel());
			newOffer.setCreatedon(new Timestamp(System.currentTimeMillis()));
			newOffer.setExpirydate(cpo.getExpirydate());
			newOffer.setIncome(cpo.getIncome());
			newOffer.setIndicativeLimit(cpo.getIndicativeLimit());
			newOffer.setIshunter(false);
			newOffer.setModelId(cpo.getModelId());
			//newOffer.setModifiedon(cpo.getModifiedon());
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
			blankResponse.setTOffer(newOffer);
			List<TCustomerResponse> listResponse = new ArrayList<TCustomerResponse>();
			listResponse.add(blankResponse);
			newOffer.setTCustomerResponses(listResponse);
			newOffer.setUserprofile1(blankResponse.getUserprofile1());
		}
		else{
			//newOffer.setArea(cpo.getArea());
			//newOffer.setBranchCategory(cpo.getBranchCategory());
			//newOffer.setBranchProduct(cpo.getBranchProduct());
			//newOffer.setChannel(cpo.getChannel());
			newOffer.setCreatedon(new Timestamp(System.currentTimeMillis()));
			//newOffer.setExpirydate(cpo.getExpirydate());
			//newOffer.setIncome(cpo.getIncome());
			//newOffer.setIndicativeLimit(cpo.getIndicativeLimit());
			newOffer.setIshunter(false);
			//newOffer.setModelId(cpo.getModelId());
			//newOffer.setModifiedon(cpo.getModifiedon());
			//newOffer.setNominal(cpo.getNominal());
			newOffer.setOfferdate(new Timestamp(System.currentTimeMillis()));
			newOffer.setProductId(blankResponse.getTProduct1().getProductId());
			newOffer.setProgram(blankResponse.getProgram());
			//newOffer.setRac(cpo.getRac());
			//newOffer.setRegion(cpo.getRegion());
			//newOffer.setScript(cpo.getScript());
			//newOffer.setSequence(cpo.getSequence());
			//newOffer.setSourceType(cpo.getSourceType());
			newOffer.setStatus(blankResponse.getResponseResult());
			newOffer.setTCpi(blankResponse.getTCpi());
			//Save single customer response
			blankResponse.setTOffer(newOffer);
			List<TCustomerResponse> listResponse = new ArrayList<TCustomerResponse>();
			listResponse.add(blankResponse);
			newOffer.setTCustomerResponses(listResponse);
			newOffer.setUserprofile1(blankResponse.getUserprofile1());
		}
		
		 try {
			 if(cpoid != null || cpoid != ""){
				 cpoRepo.setFlagTcpo(cpo.getCpoId());
			 }
			 tofferRepo.save(newOffer);
		  } catch (Exception ex) {
		    // trigger rollback programmatically
		    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		    return Pair.of(1,"Tangggapan tidak berhasil disimpan");
		  }
		
		 System.out.println("TCpoid = "+cpo.getCpoId()+" / Offerid = "+ newOffer.getId());
		return Pair.of(0,"Tanggapan berhasil disimpan");
	}

}
