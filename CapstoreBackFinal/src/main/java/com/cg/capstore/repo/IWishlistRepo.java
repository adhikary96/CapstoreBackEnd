package com.cg.capstore.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.bean.WishlistBean;

@Repository
public interface IWishlistRepo extends JpaRepository<WishlistBean, String>{
	
	/*@Query("SELECT w FROM WishlistBean w WHERE w.wishlistId=(:id)")
	public List<ProductBean> getAllProdList(@Param(value="id") String wishlistId);*/
	

}
