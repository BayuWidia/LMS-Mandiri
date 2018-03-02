package com.mandiri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mandiri.model.Reason;
import com.mandiri.model.TCph;
import com.mandiri.model.TCpi;
import com.mandiri.model.TCpo;
import com.mandiri.model.TCustomerResponse;
import com.mandiri.model.TProduct;
import com.mandiri.model.Userprofile;
import com.mandiri.repository.CampaignRepository;
//import com.mandiri.repository.CustomerProductRepository;
import com.mandiri.repository.TCpiRepository;
import com.mandiri.repository.TCpoRepository;
import com.mandiri.repository.TCustomerResponseRepository;
import com.mandiri.repository.TProductRepository;
import com.mandiri.repository.ReasonRepository;
import com.mandiri.repository.TCphRepository;
//import com.mandiri.repository.StatusRepository;
import com.mandiri.service.TCpiService;
import com.mandiri.service.UserProfileService;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {
	
	@Autowired
	private TCpiRepository customerRepo; 
	@Autowired
	private TCphRepository cphRepo;
	@Autowired
	private TCpoRepository cpoRepo;
	@Autowired
	private TCustomerResponseRepository tresponseRepo;
	
	@Autowired
	private CampaignRepository campaignRepo;

	@Autowired
	private TProductRepository productRepo;
	
	@Autowired
	private ReasonRepository reasonRepo;

	@Autowired
	SessionController sessionController;
	
	@Autowired
	private TCpiService customerService;
	
	//Long cif = 1111L;
	
	@GetMapping(value={"/customer-edit/{cif}"})
	public String customerEdit(@PathVariable String cif, Model model, HttpSession session){
		sessionController.getSession(model, session);
			
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//User user = userService.findUserByUsername(auth.getName());
		//TCpi customer = customerService.findCustomerByCif(Long.valueOf(cif));
			
		System.out.println(System.getProperty("catalina.base"));
		
		//Get customer Information
		TCpi customer = new TCpi();
		customer = customerRepo.findbyCif(cif);
		model.addAttribute("customer", customer);
		
		//Get TCpo - offer
		List<TCpo> listNewOffer = cpoRepo.findbyCif(cif);
		System.out.println("NEW OFFER : "+listNewOffer.size());
		model.addAttribute("listNewOffer", listNewOffer);
		
		List<TCustomerResponse> listOfferd = tresponseRepo.findbyCif(cif);
		model.addAttribute("listOfferd", listOfferd);
		
		//owned product by cif
		List<TCph> listOwned = cphRepo.findbyCif(cif);
		model.addAttribute("listOwned", listOwned);
		
		//Select list product
		List<TProduct> listProduk = productRepo.findExceptTrash();
		model.addAttribute("listProduk", listProduk);
		
		//Select list product
		List<Reason> listReason = reasonRepo.findAll();
		model.addAttribute("listReason", listReason);
		
		//Blank Customer Campaign for form purpose
		TCustomerResponse blankResponse = new TCustomerResponse();
		blankResponse.setTCpi(new TCpi(cif));
		model.addAttribute("blankResponse", blankResponse);
		
		return "CustomerView";
	}
	
	@PostMapping(value={"/responseSave"})
	public @ResponseBody String responseSave(@ModelAttribute(value="blankResponse") TCustomerResponse blankResponse, HttpEntity<String> httpEntity) {
		blankResponse.setCreatedon(new Timestamp(System.currentTimeMillis()));
		Userprofile createdby = new Userprofile();
		createdby.setNip("2222222223");
		blankResponse.setUserprofile1(createdby);
		
	    String json = httpEntity.getBody();
		System.out.println(json);
		
		tresponseRepo.save(blankResponse);
		
		return "test";
	}

	@GetMapping(value={"/getDetailProduct"})
	@ResponseBody
	public String getDetailProduct(@RequestParam("id") String id){
		System.out.println(id);
		
		TProduct prod = new TProduct();
		prod = productRepo.findbyId(id);
		
		return prod.getDetail();
	}
//	
//	//Testing post from ajax
//	@GetMapping(value={"/Test"})
//	public String mytest(ModelMap model){
//		Reason reason = new Reason();
//		model.addAttribute("reason", reason);
//		return "Test";
//	}
//
//	@PostMapping(value={"/Test"})
//	@ResponseBody
//	public String mytestPost(@ModelAttribute(value="reason") Reason reason, HttpEntity<String> httpEntity){
//		String json = httpEntity.getBody();
//		System.out.println(json.toString());
//		System.out.println(reason.toString());
//		return "Test";
//	}
//	
//	//TEST1
//	@GetMapping(value={"/myNewHello"})
//	public ModelAndView myNewHello(){
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("myNewHello");
//		return modelAndView;
//	}
//	
//	//TEST2
//	@GetMapping(value={"/MyHelloWorld"})
//	public String helloWorldvariable(ModelMap model){
//		model.addAttribute("myFirstVariable", "Hehe");
//		return "MyHelloWorld";
//	}
}
