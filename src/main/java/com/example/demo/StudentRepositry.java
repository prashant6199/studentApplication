package com.example.demo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Registration;

@Repository
public interface StudentRepositry extends CrudRepository<Registration, Long> {
	
@Query(value="SELECT * from registration r WHERE LOWER(r.name) = LOWER(:name)",nativeQuery = true)
	List<Registration>findByName(@Param("name") String name);

@Query(value="SELECT * FROM registration r WHERE LOWER(r.name)=LOWER(:name) and LOWER(r.age)=LOWER(:age)",nativeQuery = true)
List<Registration>findByNameAndAge(@Param("name") String name,@Param("age") int age);

}
