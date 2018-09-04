package com.cg.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.capstore.bean.CustomerBean;
import com.cg.capstore.bean.ProductBean;

@Repository
public interface ICustomerRepo extends JpaRepository<CustomerBean, String>{
	


}
