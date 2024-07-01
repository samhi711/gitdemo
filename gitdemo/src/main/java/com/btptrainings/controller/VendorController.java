package com.btptrainings.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btptrainings.entities.Vendor;
import com.btptrainings.service.vendorService;


@RestController
public class VendorController {
	
	
	@Autowired
	vendorService vendorService;
	
	//ES_GETENTITYSET
	@RequestMapping("/Vendor")
	public List<Vendor> getVendors(){
		return vendorService.readAllVendors();
		}
	
	//ES_CREATE_ENTITY
		@PostMapping("/Vendor")
		public Vendor createVendor(@RequestBody Vendor myPostBody) {
			//myPostBody.code = "newlyCreated" ;
			return vendorService.createVendor(myPostBody);
		}
		
	
	//Test using localhost:8080/vendor/search?company=SAP
	@RequestMapping("/Vendor/search")
	public List<Vendor> searchByCompany(@RequestParam String company){
		return vendorService.searchByCompanyName(company);
	}
	
	//Test Uing localhost:8080/Vendor/lookUp/23
	//@RequestMapping("/Vendor/lookUp")  -same usage as below
	@RequestMapping("/Vendor/lookUp/{gstNo}")
	public List<Vendor> searchVendorByGST(@PathVariable("gstNo") String GSTNo){
		return vendorService.lookUpVendorByGST(GSTNo);
	}
	
	
	
	//ES_GETENTITY
	@RequestMapping("/Vendor/{vendorCode}")
	public Vendor getVendorById(@PathVariable("vendorCode") Long Code) {
		return vendorService.getSingleVendor(Code);	
	}
	
	
	//@PutMapping("/Vendor")
	@RequestMapping(method=RequestMethod.PUT , value = "/Vendor")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return vendorService.changeVendor(vendor);
	}
	
	//test - http://localhost:8080/Vendor/52
	@RequestMapping(method=RequestMethod.DELETE , value = "/Vendor/{id}")
	public String removeVendor(@PathVariable("id") Long id) {
		return vendorService.deleteVendor(id);
	}
	
	
	

	
	

}
