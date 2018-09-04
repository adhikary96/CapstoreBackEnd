package com.cg.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.capstore.bean.ProductBean;

@Repository
public interface SimilarProductsRepo extends JpaRepository<ProductBean, String>{
	@Query("select p.productName from ProductBean p  where p.category=(:category) order by p.category")
	public List<ProductBean> getSimilarProducts(@Param(value="category") String category);
	
}
