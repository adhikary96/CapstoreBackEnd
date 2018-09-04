package com.cg.capstore.service;

import com.cg.capstore.exception.DiscountException;

public interface IApplyDiscountService {
	public String Discount(String pid) throws DiscountException;

}
