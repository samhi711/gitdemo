package com.btptrainings.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.btptrainings.entities.Vendor;

@Component
public class vendorService {
	
	@Autowired
    IVendorPersistence vendor;
	
	public List<Vendor> readAllVendors(){
		return vendor.findAll();
	}

//	public Vendor getSingleVendorById(String Id) {
//		return (Vendor)vendors.get(Id);
//	}
//	
	public Vendor changeVendor(Vendor payload) {
		Optional<Vendor> myvendor = vendor.findById(payload.id);
		if(!myvendor.isPresent()) {
			return new Vendor((long)0,"","","",null, null, null, null);
		}
		return vendor.save(payload);
	}
	
	public Vendor createVendor(Vendor vendorObj) {
		return vendor.save(vendorObj);
		
	}
	
	public List<Vendor> searchByCompanyName(String companyName){
		return vendor.findByCompanyName(companyName);
	
	}
	
	public List<Vendor> lookUpVendorByGST(String GSTNo){
		return vendor.lookUpVendorByGST(GSTNo);
	}
	
	public Vendor getSingleVendor(Long id) {
		Optional<Vendor> searchResult = vendor.findById(id);
		if(!searchResult.isPresent()) {
			return new Vendor((long)0,"","","",null, null, null, null);
		}
		return searchResult.get();	
	}
	
	public String deleteVendor(Long id) {
		vendor.deleteById(id);
		return "Deleted Successfully";
		}
	
	
	
	

}
