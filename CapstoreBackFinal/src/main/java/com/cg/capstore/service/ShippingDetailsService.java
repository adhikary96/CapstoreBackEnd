package com.cg.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.bean.CustomerBean;
import com.cg.capstore.repo.IShippingDetailsRepo;

@Service
public class ShippingDetailsService implements IShippingDetailsService {

    @Autowired
	private IShippingDetailsRepo repo;
	
	@Override
	public CustomerBean shippingDetailsMsg(String email) {
		
		CustomerBean customerBean=repo.getCustDetails(email);
		
		return customerBean;
	}

}
