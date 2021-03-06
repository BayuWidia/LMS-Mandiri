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
import org.springframework.stereotype.Service;

import com.mandiri.filter.DashboardFilter;
import com.mandiri.model.TAuditTrail;
import com.mandiri.repository.DashboardRepository;
import com.mandiri.repository.TCustomerResponseRepository;
import com.mandiri.util.CustomeUtil;

@Service
public class DashboardService {

	@Autowired
	private DashboardRepository dashboardRepository;
	
	@Autowired
	private TCustomerResponseRepository tCustomerResponseRepository;
	
	CustomeUtil customeUtil = new CustomeUtil();

	public List<TAuditTrail> findAll() {
		return dashboardRepository.findAll();
	}

	public List<DashboardFilter> listUserActivityRight(String userNip) {
		List<Object[]> lsData = new ArrayList<>();
		lsData = dashboardRepository.findTAuditTrail(userNip);

		return convertlistTAuditTrail(lsData);
	}

	public List<DashboardFilter> convertlistTAuditTrail(List<Object[]> lsData) {
		List<DashboardFilter> lsDataTest = new ArrayList<>();

		for (Object[] data : lsData) {
			DashboardFilter f = new DashboardFilter();
			f.setId((BigInteger) data[0]);
			
			String strInfo = (String) data[1];
			String[] parts = strInfo.split(",");
			String part1 = parts[0];
			String part2 = parts[1]; 
			f.setInfo(part1);
			f.setInfoCifTemp(part2);
			f.setUser_nip((String) data[2]);
			
			Date date = (Timestamp) data[3];
			DateFormat fmtDate = new SimpleDateFormat("dd MMMM yyyy");
			DateFormat fmtDay = new SimpleDateFormat("EEEE");
			String strDate = fmtDate.format(date);
			String strDay = fmtDay.format(date);
			f.setCreatedon(strDate);
			f.setDay(strDay);
			f.setCreatedby((Integer) data[4]);
			
			lsDataTest.add(f);
		}
		return lsDataTest;
	}
	
	
	public List<DashboardFilter> listUserActivityLeft(String userNip) {
		List<Object[]> lsData = new ArrayList<>();
		lsData = tCustomerResponseRepository.findReminderOn(userNip);

		return convertlistReminderOn(lsData);
	}

	public List<DashboardFilter> convertlistReminderOn(List<Object[]> lsData) {
		List<DashboardFilter> lsDataTest = new ArrayList<>();

		for (Object[] data : lsData) {
			DashboardFilter f = new DashboardFilter();
			f.setCustomerResponseId((String) data[0]);
			Date date = (Timestamp) data[1];
			DateFormat fmtDate = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss");
			String strDate = fmtDate.format(date);
			f.setReminder(strDate);
			f.setNama_cpi((String) data[2]);
			f.setProduct_name((String) data[3]);
			
			lsDataTest.add(f);
		}
		return lsDataTest;
	}

	public List<DashboardFilter> listSearchByParam(String strKategori, String strPencarian){
		List<Object[]> lsData = null;
		if (strKategori.equalsIgnoreCase("NIK")) {
			lsData = dashboardRepository.findJoinSearchByNik(strPencarian.toLowerCase());
		} else if (strKategori.equalsIgnoreCase("PHONE")){
			lsData = dashboardRepository.findJoinSearchByPhone(strPencarian.toLowerCase());
		} else if (strKategori.equalsIgnoreCase("NAME")){
			lsData = dashboardRepository.findJoinSearchByName(strPencarian.toLowerCase());
		} else if (strKategori.equalsIgnoreCase("CIF")){
			lsData = dashboardRepository.findJoinSearchByCif(new BigInteger(strPencarian));
		} else if (strKategori.equalsIgnoreCase("NOREK")){
			lsData = dashboardRepository.findJoinSearchByNorek(new BigInteger(strPencarian));
		} else if (strKategori.equalsIgnoreCase("NOKAR")){
			lsData = dashboardRepository.findJoinSearchByNokar(new BigInteger(strPencarian));
		}
		
		return convertlistSearchByParam(lsData);
	}
	
	public List<DashboardFilter> convertlistSearchByParam(List<Object[]> lsData){
		List<DashboardFilter> lsDataSearch =new ArrayList<>();
		
		for(Object[] data:lsData){
			DashboardFilter f=new DashboardFilter();
			f.setCif((String) data[0]);
			f.setName((String) data[1]);
			f.setNik((String) data[2]);
			f.setEmail((String) data[3]);
			f.setPhone((String) data[4]);
			f.setAddress((String) data[5]);
			f.setBirthdate((Date) data[6]);
			f.setBirthplace((String) data[7]);
			f.setIndentitytype((String) data[8]);
			f.setGender((String) data[9]);
			f.setBranchid((String) data[10]);
			f.setMothername((String) data[11]);
			f.setCreatedon2(customeUtil.formatDate((Date) data[12]));
			f.setModifiedon((String) data[13]);
			f.setCreatedby2((String) data[14]);
			f.setModifiedby((String) data[15]);
			
			f.setCif2((String) data[16]);
			f.setAccountno((String) data[17]);
			f.setAccountNumber((String) data[18]);
			f.setCardNumber((String) data[19]);
			
			lsDataSearch.add(f);
		}
		
		return lsDataSearch;
	}

}
