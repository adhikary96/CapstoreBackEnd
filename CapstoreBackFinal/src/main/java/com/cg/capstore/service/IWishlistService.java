package com.cg.capstore.service;


import java.util.List;

import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.bean.WishlistBean;

public interface IWishlistService {

	public ProductBean addProduct(String productId, String email);
	public WishlistBean deleteProductsFromWishlist(String email,String productId);
	public WishlistBean displayProductsFromWishlist(String email);
	//public List<ProductBean> displayProductsFromWishlist(String email);

}
