package com.cg.capstore.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.service.ISimilarProductService;

@RestController
public class SimilarProductsController {
	@Autowired
	private ISimilarProductService service;
	@RequestMapping(value="/displayAllSimilarProducts", method=RequestMethod.GET)
	public List<ProductBean> SimilarProductsInterface(String category) {
		return service.displaySimilarProducts(category);
	}

}

