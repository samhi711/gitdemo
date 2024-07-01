package com.btptrainings.service;

import java.util.List;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.btptrainings.entities.*;

@Component
public class addressService {
	
	@Autowired
	IAddressPersistence address;
	
	
	public List<address> getAddress(){
		return address.findAll();
	}
	
	
	public address createAddress(address payload) {
		return address.save(payload);
	}
	

}
