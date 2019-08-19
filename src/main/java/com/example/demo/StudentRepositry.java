package com.example.demo;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Registration;

@Transactional
@Repository
public interface StudentRepositry extends CrudRepository<Registration, Integer> {
	
@Query(value="SELECT * from registration r WHERE LOWER(r.name) = LOWER(:name)",nativeQuery = true)
	List<Registration>findByName(@Param("name") String name);

@Query(value="SELECT * FROM registration r WHERE LOWER(r.name)=LOWER(:name) and LOWER(r.password)=LOWER(:password)",nativeQuery = true)
List<Registration>findByNameAndPassword(@Param("name") String name,@Param("password") String password);

 @Modifying  
 @Query(value="Update registration r SET r.name=:name , r.age=:age , r.percentage=:percentage , r.total_marks=:total_marks  WHERE r.sid=:sid" ,nativeQuery = true) 
public int Update(@Param("sid") int sid,@Param("name") String name, @Param("age") int age, @Param("percentage") double percentage, @Param("total_marks") int total_marks);
	 
	/*
	 * @Modifying
	 * 
	 * @Query(
	 * value="Update registration r SET r.name=:name,r.age=:age WHERE r.sid=:sid"
	 * ,nativeQuery = true) public int Update(@Param("sid") int sid,@Param("name")
	 * String name, @Param("age") int age);

	 */
 @Modifying
 @Query(value="Delete FROM registration  WHERE sid=:sid",nativeQuery = true)
 public int delete(@Param("sid") int sid);
 
 @Query(value="SELECT * FROM registration WHERE name=:name and password=:password", nativeQuery = true)
 Registration findData(@Param("name" ) String name, @Param("password") String password);
 
 @Modifying  
 @Query(value="Update registration SET password=:password   WHERE sid=:sid and name=:name" ,nativeQuery = true)
 public int updatePassword(@Param("name") String name, @Param("sid") int sid, @Param("password") String password);
 
 @Query(value="SELECT * from registration  ORDER BY percentage DESC,name",nativeQuery = true)
	List<Registration>findByASCName();
 


}
