package com.btptrainings.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.btptrainings.entities.*;

@RepositoryRestResource(collectionResourceRel = "vendor",path="newVendor1")
public interface IVendorNewController extends JpaRepository<Vendor, Long>{

}
