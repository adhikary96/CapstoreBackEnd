package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.capstore.bean.CustomerBean;

@Repository
public interface IInviteFriendRepo extends JpaRepository<CustomerBean, String>{
	
	@Query(value="SELECT c.email from CustomerBean c WHERE c.customerName=(:name)")
	public String getCustomerEmail(@Param(value="name") String customerName);
	
	
}
