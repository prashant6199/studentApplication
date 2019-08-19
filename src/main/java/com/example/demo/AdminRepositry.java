package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AdminLogin;
import com.example.demo.model.Registration;

@Repository
public interface AdminRepositry extends CrudRepository<AdminLogin,Long>{
	
	@Query(value="SELECT * from admin_login a WHERE LOWER(a.name) = LOWER(:name)",nativeQuery = true)
	List<AdminLogin>findByName(@Param("name") String name);

}
