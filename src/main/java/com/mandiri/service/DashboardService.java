package com.mandiri.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandiri.filter.DashboardFilter;
import com.mandiri.model.UserActivity;
import com.mandiri.repository.DashboardRepository;
import com.mandiri.util.CustomeUtil;

@Service
public class DashboardService {

	@Autowired
	private DashboardRepository dashboardRepository;
	
	CustomeUtil customeUtil = new CustomeUtil();

	public List<UserActivity> findAll() {
		return dashboardRepository.findAll();
	}

	public List<DashboardFilter> listUserActivity(String createdBy) {

		List<Object[]> lsData = new ArrayList<>();
		lsData = dashboardRepository.findUserActivity(createdBy);

		return convertlist(lsData);
	}

	public List<DashboardFilter> convertlist(List<Object[]> lsData) {
		List<DashboardFilter> lsDataTest = new ArrayList<>();

		for (Object[] data : lsData) {
			DashboardFilter f = new DashboardFilter();
			f.setId((BigInteger) data[0]);
			f.setAction((String) data[1]);
			f.setCif((BigInteger) data[2]);
			
			Date date = (Timestamp) data[3];
			DateFormat fmtDate = new SimpleDateFormat("dd MMMM yyyy");
			DateFormat fmtDay = new SimpleDateFormat("EEEE");
			String strDate = fmtDate.format(date);
			String strDay = fmtDay.format(date);
			
			f.setCreatedon(strDate);
			f.setCreatedby((String) data[4]);
			f.setDay(strDay);
			
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
			f.setCif((BigInteger) data[0]);
			f.setName((String) data[1]);
			f.setNik((String) data[2]);
			f.setEmail((String) data[3]);
			f.setPhone((String) data[4]);
			f.setAddress((String) data[5]);
			f.setBirthdate((Date) data[6]);
			f.setBirthplace((String) data[7]);
			f.setIndentitytype((String) data[8]);
			f.setGender((String) data[9]);
			f.setBranchid((BigInteger) data[10]);
			f.setMothername((String) data[11]);
			f.setCreatedon2(customeUtil.formatDate((Date) data[12]));
			f.setModifiedon((String) data[13]);
			f.setCreatedby2((String) data[14]);
			f.setModifiedby((String) data[15]);
			
			f.setId2((BigInteger) data[16]);
			f.setProductid((Integer) data[17]);
			f.setAccountno((BigInteger) data[18]);
			f.setCardno((BigInteger) data[19]);
			f.setLeanno((BigInteger) data[20]);
			f.setCreatedon3(customeUtil.formatDate((Date) data[21]));
			f.setCreatedby3((String) data[22]);
			f.setModifiedon3((String) data[23]);
			f.setModifiedby3((String) data[24]);
//			f.setDetail((String) data[25]);
			
			lsDataSearch.add(f);
		}
		
		return lsDataSearch;
	}

}
