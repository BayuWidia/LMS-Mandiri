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
//	@Autowired
//	private UserProfileService userService;
	
	
	//Long cif = 1111L;
	
	@GetMapping(value={"/customer-edit/{cif}"})
	public String customerEdit(@PathVariable String cif, Model model, HttpSession session){
		sessionController.getSession(model, session);
			
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//User user = userService.findUserByUsername(auth.getName());
		//TCpi customer = customerService.findCustomerByCif(Long.valueOf(cif));
			
		System.out.println(System.getProperty("catalina.base"));
		
		//Get customer Information
		TCpi cust = new TCpi();
		cust = customerRepo.findbyCif(cif);
		System.out.println(cust.toString());
		model.addAttribute("customer", cust);
		
		//owned product by cif
		List<TCph> listOwned = cphRepo.findbyCif(cif);
		model.addAttribute("ownedProduct", listOwned);
		
		//Customer Campaign
		//List<CustomerCampaign> listCampaign = campaignRepo.findbyCif(cif);
		//List<CustomerCampaign> campaign0 = listCampaign.stream().filter(p->p.getStatus().getId() == 0).collect(Collectors.toList());
		//List<CustomerCampaign> campaign1 = listCampaign.stream().filter(p->p.getStatus().getId() == 1).collect(Collectors.toList());
		
		//Get TCpo - offer
		List<TCpo> listOffer = cpoRepo.findbyCif(cif);
		model.addAttribute("newOffer", listOffer);
		
		List<TCustomerResponse> listOfferd = tresponseRepo.findbyCif(cif);
		model.addAttribute("offered", listOfferd);
		
		//Select list product
		List<TProduct> listProduk = productRepo.findAll();
		model.addAttribute("listProduct", listProduk);
		
		//Select list product
		List<Reason> listReason = reasonRepo.findAll();
		model.addAttribute("listReason", listReason);
		
		//Button group status
		//List<Status> listStatus = statusRepo.findAll();
		//model.addAttribute("listStatus", listStatus);
		
		//Blank Customer Campaign for form purpose
		TCustomerResponse blankResponse = new TCustomerResponse();
		blankResponse.setTCpi(new TCpi(cif));
		model.addAttribute("blankResponse", blankResponse);
		
		return "CustomerView";
	}
//	
	@PostMapping(value={"/responseSave"})
//	public String customerSingleView(@ModelAttribute("blankCampaign") CustomerCampaign blankCampaign){
//		System.out.println(blankCampaign.toString());
	public @ResponseBody String responseSave(@ModelAttribute(value="blankResponse") TCustomerResponse blankResponse, HttpEntity<String> httpEntity) {
		blankResponse.setCreatedon(new Timestamp(System.currentTimeMillis()));
		Userprofile createdby = new Userprofile();
		createdby.setNip("2222222223");
		blankResponse.setUserprofile1(createdby);
		
	    String json = httpEntity.getBody();
		System.out.println(json);
		//System.out.println(blankCampaign.getEmail());
//		if (result.hasErrors()) {
//	        System.out.println(result.getGlobalError() + "" + result.getFieldError());
//	    }
//		System.out.println(blankCampaign.toString());
//		System.out.println(blankCampaign.getProduct1().getName());
		tresponseRepo.save(blankResponse);
		
		return "test";
	}
//	
//	
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
