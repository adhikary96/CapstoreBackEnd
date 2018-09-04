package com.cg.capstore.service;

import java.util.List;

import com.cg.capstore.bean.ProductBean;

public interface ISimilarProductService {
	public List<ProductBean> displaySimilarProducts(String category);
	
}