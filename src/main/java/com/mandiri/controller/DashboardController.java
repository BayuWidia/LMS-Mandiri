package com.mandiri.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.mandiri.filter.UserProfileFilter;
import com.mandiri.model.TAuditTrail;
import com.mandiri.model.Userprofile;
import com.mandiri.repository.DashboardRepository;
import com.mandiri.service.TCpiService;
import com.mandiri.service.DashboardService;
import com.mandiri.service.UserProfileService;
import com.mandiri.util.StringUtil;

@Controller
public class DashboardController {

	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private DashboardService dashboardService;
	
	@Autowired
	private DashboardRepository dashboardRepository;
	
	@Autowired
	SessionController sessionController;
	
	@Autowired
	private TCpiService tCpiService;
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		sessionController.getSession(model, session);
		
//		ModelAndView modelAndView = (ModelAndView) model;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Userprofile user = userProfileService.findUserProfileByNip(auth.getName());
		
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
		model.addAttribute("userActivitys", dashboardService.listUserActivity(user.getNip()));
		
		return "dashboard";
	}
	
	@RequestMapping(path="/dashboard-search", method=RequestMethod.POST)
	public String dashboardSearch(@ModelAttribute("dashboardFilter") DashboardFilter dashboardFilter, Model model, HttpSession session) {
		sessionController.getSession(model, session);
		model.addAttribute("userName", "");
		
		String strKategori = StringUtil.nvl(dashboardFilter.getKategori(), "");
		String strPencarian = StringUtil.nvl(dashboardFilter.getPencarian(), "");
		
		
		if (strKategori == "") {
			model.addAttribute("messageStrKategori", "Kategori Harus Diisi");
		} else if (strPencarian == "") {
			model.addAttribute("messageStrPencarian", "Pencarian Harus Diisi");
		} else {
			List<DashboardFilter> listData = dashboardService.listSearchByParam(strKategori, strPencarian);
			System.out.println("listData ::: "+listData);
			if (listData.size() == 0) {
				model.addAttribute("messageDataKosong", "Data yang anda cari tidak ditemukan");
			}
			model.addAttribute("listDatas",listData);
			
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Userprofile user = userProfileService.findUserProfileByNip(auth.getName());
		Date date = new Date();
		DateFormat fmtDate = new SimpleDateFormat("dd");
		DateFormat fmtMon = new SimpleDateFormat("MMMM");
		DateFormat fmtYear = new SimpleDateFormat("yyyy");
		DateFormat fmtDay = new SimpleDateFormat("EEEE");
		
		String strDate = fmtDate.format(date);
		String strMon = fmtMon.format(date);
		String strYear = fmtYear.format(date);
		String strDay = fmtDay.format(date);
		
		if (strKategori.equalsIgnoreCase("NIK")) {
			strKategori = "Nomor Induk Karyawan";
		} else if (strKategori.equalsIgnoreCase("PHONE")){
			strKategori = "Telephone";
		} else if (strKategori.equalsIgnoreCase("NAME")){
			strKategori = "Nama";
		} else if (strKategori.equalsIgnoreCase("CIF")){
			strKategori = "Cif";
		} else if (strKategori.equalsIgnoreCase("NOREK")){
			strKategori = "Nomor Rekening";
		} else if (strKategori.equalsIgnoreCase("NOKAR")){
			strKategori = "Nomor Kartu";
		}
		
		TAuditTrail ua = new TAuditTrail();
		ua.setInfo("Melakukan pencarian customer dengan kriteria "+strKategori+" "+strPencarian+","+"null");
		ua.setAudited(new Timestamp(System.currentTimeMillis()));
		ua.setUserprofile3(user);
		ua.setUserprofile1(user);
		ua.setCreatedon(new Timestamp(System.currentTimeMillis()));
		dashboardRepository.save(ua);
		
		model.addAttribute("strDate", strDate);
		model.addAttribute("strMon", strMon);
		model.addAttribute("strYear", strYear);
		model.addAttribute("strDay", strDay);
		
		CustomerFilter customerFilter = new CustomerFilter();
		model.addAttribute("customerFilter", customerFilter);
		model.addAttribute("dashboardFilter", dashboardFilter);
		model.addAttribute("userName", user.getName());
		model.addAttribute("userActivitys", dashboardService.listUserActivity(user.getNip()));
		
		return "hasilsearch";
	}
	
	@RequestMapping(value="/customer-edit-all-dashboard/{cif}", method=RequestMethod.GET)
	public String customerEditAll(@PathVariable String cif, Model model, HttpSession session){
		sessionController.getSession(model, session);
		
		System.out.println("customer-edit-all-dashboard ::: "+cif);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Userprofile user = userProfileService.findUserProfileByNip(auth.getName());
//		Cus customer = customerService.findCustomerByCif(Long.valueOf(cif));
		
		return "redirect:/dashboard";
	}

}
