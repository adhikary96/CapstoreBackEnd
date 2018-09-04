package com.cg.capstore.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.repo.SimilarProductsRepo;

@Service
public class SimilarProductsService implements ISimilarProductService{
	@Autowired
	private SimilarProductsRepo repo;

	@Override
	public List<ProductBean> displaySimilarProducts(String category) {
		// TODO Auto-generated method stub
		return repo.getSimilarProducts(category);
	}
	
}
