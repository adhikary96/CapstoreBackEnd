package com.cg.capstore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.cg.capstore.bean.CustomerBean;
import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.bean.WishlistBean;
import com.cg.capstore.repo.ICustomerRepo;
import com.cg.capstore.repo.IProductRepo;
import com.cg.capstore.repo.IWishlistRepo;
@Service
public class WishlistService implements IWishlistService{

	@Autowired
	IWishlistRepo wishlistrepo;
	
	@Autowired
	ICustomerRepo wishlistcustomerrepo;
	
	@Autowired
	IProductRepo wishlistproductrepo;
	
	@Override
	public ProductBean addProduct(String productId, String email) {
		ProductBean product = wishlistproductrepo.getOne(productId);
		CustomerBean customer = wishlistcustomerrepo.getOne(email);
		WishlistBean wishlist = customer.getWishlist();
		List<ProductBean> prod = wishlist.getProductId();
		wishlist.setProductId(prod);
		prod.add(product);
		wishlist.setProductId(prod);
		wishlistrepo.save(wishlist);
		return product;
	}

	@Override
	public WishlistBean deleteProductsFromWishlist(String email,String productId) {
		ProductBean product = wishlistproductrepo.getOne(productId);
		CustomerBean customer = wishlistcustomerrepo.getOne(email);
		WishlistBean wishlist=wishlistrepo.getOne(customer.getWishlist().getWishlistId());
		List<ProductBean> prod = wishlist.getProductId();
		prod.remove(product);
		wishlist.setProductId(prod);
		wishlistrepo.save(wishlist);
		return wishlist;
		
	}

	@Override
	public WishlistBean displayProductsFromWishlist(String email) {
		System.err.println("email:"+email);
		CustomerBean customer = wishlistcustomerrepo.getOne(email);
		String wishlistId = customer.getWishlist().getWishlistId();
		System.err.println("wishlist id:"+wishlistId);
		System.err.println(customer.getWishlist().getProductId());
		System.err.println("Wishlist : "+wishlistrepo.getOne(wishlistId));
		return wishlistrepo.getOne(wishlistId);
	}
	
	/*@Override
	public List<ProductBean> displayProductsFromWishlist(String email) {
		System.err.println("email:"+email);
		CustomerBean customer = wishlistcustomerrepo.getOne(email);
		String wishlistId = customer.getWishlist().getWishlistId();
		System.err.println("wishlist id:"+wishlistId);
		System.err.println(customer.getWishlist().getProductId());
		System.err.println("Wishlist : "+wishlistrepo.getOne(wishlistId));
		return wishlistrepo.getAllProdList(wishlistId);
	}*/
}
