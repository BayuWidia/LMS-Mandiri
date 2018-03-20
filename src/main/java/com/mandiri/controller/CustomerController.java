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
import com.mandiri.model.GroupProduct;
import com.mandiri.model.Keytracking;
import com.mandiri.model.Program;
import com.mandiri.model.Reason;
import com.mandiri.model.TCph;
import com.mandiri.model.TCpi;
import com.mandiri.model.TCpo;
import com.mandiri.model.TCustomerResponse;
import com.mandiri.model.TProduct;
import com.mandiri.model.Userprofile;
import com.mandiri.model.Viewkeytracking;
import com.mandiri.model.Viewproduct;
import com.mandiri.model.Viewprogram;
import com.mandiri.repository.CampaignRepository;
import com.mandiri.repository.GroupProductRepository;
import com.mandiri.repository.KeytrackingRepository;
import com.mandiri.repository.ViewProductRepository;
import com.mandiri.repository.ViewProgramRepository;
import com.mandiri.repository.ProgramRepository;
//import com.mandiri.repository.CustomerProductRepository;
import com.mandiri.repository.TCpiRepository;
import com.mandiri.repository.TCpoRepository;
import com.mandiri.repository.TCustomerResponseRepository;
import com.mandiri.repository.TProductRepository;
import com.mandiri.repository.ViewKeytrackingRepository;
import com.mandiri.repository.ReasonRepository;
import com.mandiri.repository.TCphRepository;
//import com.mandiri.repository.StatusRepository;
import com.mandiri.service.TCpiService;
import com.mandiri.service.UserProfileService;
import com.mandiri.util.GenerateUUID;

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
	private GroupProductRepository pgroupRepo;
	@Autowired
	private CampaignRepository campaignRepo;
	@Autowired
	private ProgramRepository programRepo;
	@Autowired
	private TProductRepository productRepo;
	@Autowired
	private KeytrackingRepository keytrackingRepo;
	@Autowired
	private ReasonRepository reasonRepo;
	@Autowired
	private ViewProductRepository viewProductRepo;
	@Autowired
	private ViewProgramRepository viewProgramRepo;
	@Autowired
	private ViewKeytrackingRepository viewKeytrackingRepo;
	@Autowired
	SessionController sessionController;
	
	@Autowired
	private TCpiService customerService;
	
	//Long cif = 1111L;
	
	@GetMapping(value={"/customer-view/{cif}"})
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
//		List<TProduct> listProduk = productRepo.findExceptTrash();
//		model.addAttribute("listProduk", listProduk);
		
		//Select list groupproduct
		List<GroupProduct> listGroupProduct = pgroupRepo.findAll();
		model.addAttribute("listGroupProduct", listGroupProduct);
		
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
		System.out.println(blankResponse.toString());
		blankResponse.setCustomerResponseId(GenerateUUID.getUUID());
		
		blankResponse.setCreatedon(new Timestamp(System.currentTimeMillis()));
		Userprofile createdby = new Userprofile();
		createdby.setNip("2222222223");
		blankResponse.setUserprofile1(createdby);
		
	    String json = httpEntity.getBody();
		System.out.println(json);
		
		//tresponseRepo.save(blankResponse);
		
		return "test";
	}

	@GetMapping(value={"/getDetailProduct"})
	@ResponseBody
	public String getDetailProduct(@RequestParam("id") String id){
		TProduct prod = new TProduct();
		prod = productRepo.findbyId(id);
		
		return prod.getDetail();
	}
	
	@GetMapping(value={"/getReasonList"})
	@ResponseBody
	public List<Reason> getReasonList(@RequestParam("productGroup") String productGroup){
		System.out.println(productGroup);
		
		List<Reason> listReason = reasonRepo.findbyGroup(productGroup);
		
		return listReason;
	}
	
	@GetMapping(value={"/getProductbyGroup"})
	@ResponseBody
	public List<Viewproduct> getProductbyGroup(@RequestParam("groupproductid") Long groupproductid){
		//System.out.println(groupproductid);
		
		//TProduct listProduct = productRepo.findByGroupProduct(groupproductid);
		List<Viewproduct> listProduct = viewProductRepo.findbyGroupProductid(groupproductid);
		
		System.out.println("begok" + listProduct);
		
		return listProduct;
	}
	
	@GetMapping(value={"/getProgrambyProduct"})
	@ResponseBody
	public List<Viewprogram> getProgrambyProduct(@RequestParam("productid") String productid){
		System.out.println(productid);
		
		List<Viewprogram> listProgram = viewProgramRepo.findbyProductid(productid);
		
		return listProgram;
	}
	
	@GetMapping(value={"/getKeytrackingbyProgram"})
	@ResponseBody
	public List<Viewkeytracking> getKeytrackingbyProgram(@RequestParam("programid") Long programid){
		System.out.println(programid);
		
		List<Viewkeytracking> listKeytracking = viewKeytrackingRepo.findbyProgramid(programid);
		System.out.println("flagkey "+listKeytracking.toString());
		
		return listKeytracking;
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
