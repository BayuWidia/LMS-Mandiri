package com.mandiri.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mandiri.filter.CustomerFilter;
import com.mandiri.filter.DashboardFilter;
import com.mandiri.model.TAuditTrail;
import com.mandiri.model.TCpi;
import com.mandiri.model.TCustomerResponse;
import com.mandiri.model.TOccupation;
import com.mandiri.model.Userprofile;
//import com.mandiri.model.Customer;
//import com.mandiri.model.User;
//import com.mandiri.model.UserActivity;
import com.mandiri.repository.TCpiRepository;
import com.mandiri.repository.TCustomerResponseRepository;
import com.mandiri.repository.TOccupationRepository;
import com.mandiri.repository.DashboardRepository;
import com.mandiri.service.TCpiService;
import com.mandiri.service.DashboardService;
import com.mandiri.service.UserProfileService;

@Controller
public class HasilSearchController {

	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private TCpiService tCpiService;
	
	@Autowired
	private DashboardService dashboardService;
	
	@Autowired
	private DashboardRepository dashboardRepository;
	
	@Autowired
	private TCpiRepository tCpiRepository;
	
	@Autowired
	private TOccupationRepository tOccupationRepository;
	
	@Autowired
	private TCustomerResponseRepository tCustomerResponseRepository;
	
	@Autowired
	SessionController sessionController;
	
	@RequestMapping(value="/customer-edit-all/{cif}", method=RequestMethod.GET)
	public String customerEditAll(@PathVariable String cif, Model model, HttpSession session){
		sessionController.getSession(model, session);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Userprofile user = userProfileService.findUserProfileByNip(auth.getName());
		TCpi customer = tCpiService.findTCpiByCif(cif);
		
		TAuditTrail ua = new TAuditTrail();
		ua.setInfo("Melihat detail customer profile data dengan nama customer "+customer.getName()+","+cif);
		ua.setAudited(new Timestamp(System.currentTimeMillis()));
		ua.setCreatedon(new Timestamp(System.currentTimeMillis()));
		ua.setUserprofile1(user);
		ua.setUserprofile3(user);
		dashboardRepository.save(ua);
		
		return "redirect:/customer-view/"+cif;
	}
	
	@RequestMapping(path = "/customer-add-action", method = RequestMethod.POST)
	public String customerAddAction(@ModelAttribute("customerFilter") CustomerFilter customerFilter, Model model, HttpSession session) throws ParseException {
		sessionController.getSession(model, session);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Userprofile user = userProfileService.findUserProfileByNip(auth.getName());
		
//		TCustomerResponse cust = new TCustomerResponse();
//		cust.setPhone(customerFilter.getPhone());
//		cust.setEmail(customerFilter.getEmail());
//		cust.setUserprofile1(user);
//		cust.setCreatedon(new Timestamp(System.currentTimeMillis()));
//		tCustomerResponseRepository.save(cust);
		
		TCpi cpi = new TCpi();
		cpi.setCif(customerFilter.getCif().toString());
		cpi.setName(customerFilter.getName());
		cpi.setGender(customerFilter.getGender());
		cpi.setIdentity(customerFilter.getIndentitytype());
		cpi.setNik(customerFilter.getNik());
		cpi.setBirthPlace(customerFilter.getBirthplace());
		TOccupation tOccupation = tOccupationRepository.findByOccp(customerFilter.getJobType());
		cpi.setTOccupation(tOccupation);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate = formatter.parse(customerFilter.getBirthdate());
        cpi.setBirthDate(birthDate);
        cpi.setAddress(customerFilter.getAddress());
        cpi.setEmail(customerFilter.getEmail());
        cpi.setUserprofile1(user);
        cpi.setCreatedon(new Timestamp(System.currentTimeMillis()));
        tCpiRepository.save(cpi);
		
		Date date = new Date();
		DateFormat fmtDate = new SimpleDateFormat("dd");
		DateFormat fmtMon = new SimpleDateFormat("MMMM");
		DateFormat fmtYear = new SimpleDateFormat("yyyy");
		DateFormat fmtDay = new SimpleDateFormat("EEEE");
		
		String strDate = fmtDate.format(date);
		String strMon = fmtMon.format(date);
		String strYear = fmtYear.format(date);
		String strDay = fmtDay.format(date);
		
		model.addAttribute("strDate", strDate);
		model.addAttribute("strMon", strMon);
		model.addAttribute("strYear", strYear);
		model.addAttribute("strDay", strDay);
		
		DashboardFilter dashboardFilter = new DashboardFilter();
		model.addAttribute("dashboardFilter", dashboardFilter);
		model.addAttribute("userName", user.getName());
		model.addAttribute("listUserActivityRights", dashboardService.listUserActivityRight(user.getNip()));
		model.addAttribute("listUserActivityLefts", dashboardService.listUserActivityLeft(user.getNip()));
		model.addAttribute("messageDataSimpan", "Data tersebut berhasil disimpan");
		
		return "dashboard";
		
	}

}
