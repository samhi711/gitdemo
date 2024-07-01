package com.btptrainings.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btptrainings.entities.address;

public interface IAddressPersistence extends JpaRepository<address, Long> {
	

}
