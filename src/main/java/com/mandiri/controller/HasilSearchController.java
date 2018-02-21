package com.mandiri.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.mandiri.model.Customer;
import com.mandiri.model.User;
import com.mandiri.model.UserActivity;
import com.mandiri.repository.CustomerRepository;
import com.mandiri.repository.DashboardRepository;
import com.mandiri.service.CustomerService;
import com.mandiri.service.DashboardService;
import com.mandiri.service.UserService;

@Controller
public class HasilSearchController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DashboardService dashboardService;
	
	@Autowired
	private DashboardRepository dashboardRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	SessionController sessionController;
	
	@RequestMapping(value="/customer-edit-all/{cif}", method=RequestMethod.GET)
	public String customerEditAll(@PathVariable String cif, Model model, HttpSession session){
		sessionController.getSession(model, session);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());
		Customer customer = customerService.findCustomerByCif(Long.valueOf(cif));
		
		UserActivity ua = new UserActivity();
		ua.setAction("Melihat detail customer profile data dengan nama customer "+customer.getName());
		ua.setUser(user);
		ua.setCustomer(customer);
		ua.setCreatedon(new Timestamp(System.currentTimeMillis()));
		dashboardRepository.save(ua);
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping(path = "/customer-add-action", method = RequestMethod.POST)
	public String customerAddAction(@ModelAttribute("customerFilter") CustomerFilter customerFilter, Model model, HttpSession session) throws ParseException {
		sessionController.getSession(model, session);
		System.out.println("CIF ===>>>"+customerFilter.getCif());
		System.out.println("NAME ===>>>"+customerFilter.getName());
		System.out.println("GENDER ===>>>"+customerFilter.getGender());
		System.out.println("JENIS ID ===>>>"+customerFilter.getIndentitytype());
		System.out.println("NIK ===>>>"+customerFilter.getNik());
		System.out.println("TEMPAT LAHIR ===>>>"+customerFilter.getBirthplace());
		System.out.println("TGL LAHIR ===>>>"+customerFilter.getBirthdate());
		System.out.println("PHONE ===>>>"+customerFilter.getPhone());
		System.out.println("ALAMAT ===>>>"+customerFilter.getAddress());
		System.out.println("EMAIL ===>>>"+customerFilter.getEmail());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());
		
		Customer cust = new Customer();
		cust.setCif(customerFilter.getCif().longValue());
		cust.setName(customerFilter.getName());
		cust.setGender(customerFilter.getGender());
		cust.setIndentitytype(customerFilter.getIndentitytype());
		cust.setNik(customerFilter.getNik());
		cust.setBirthplace(customerFilter.getBirthplace());
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate = formatter.parse(customerFilter.getBirthdate());
		cust.setBirthdate(birthDate);
		cust.setPhone(customerFilter.getPhone());
		cust.setAddress(customerFilter.getAddress());
		cust.setEmail(customerFilter.getEmail());
		cust.setUser1(user);
		cust.setCreatedon(new Timestamp(System.currentTimeMillis()));
		customerRepository.save(cust);
		
		
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
		model.addAttribute("userName", user.getFullname());
		model.addAttribute("userActivitys", dashboardService.listUserActivity(user.getUsername()));
		model.addAttribute("messageDataSimpan", "Data tersebut berhasil disimpan");
		
		return "dashboard";
		
	}

}
