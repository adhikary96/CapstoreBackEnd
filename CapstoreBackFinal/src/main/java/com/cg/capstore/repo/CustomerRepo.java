package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.capstore.bean.CustomerBean;
import com.cg.capstore.bean.MerchantBean;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerBean, String>{
	
	@Query(value="SELECT c FROM CustomerBean c where c.email=(:id)")
	public CustomerBean getEmail(@Param(value = "id")String id);

}
