package com.cg.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.exception.ValidationException;
import com.cg.capstore.service.IValidationService;

@RestController
public class ValidationController {
	
	@Autowired
	IValidationService service;
	
	@RequestMapping("/validateMerchant")
	public String findMerchant(@RequestParam String emailId) throws ValidationException {
		String res = "ERROR!!!";
		try {
		res = service.findMerchant(emailId);
		}
		catch(MailException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	@RequestMapping("/validateCustomer")
	public String findCustomer(@RequestParam String email) throws ValidationException {
		String sai= "Error...";
		try {
		sai= service.findCustomer(email);
		}
		catch(MailException e) {
			System.out.println(e.getMessage());
		}
		return sai;
	}


}
