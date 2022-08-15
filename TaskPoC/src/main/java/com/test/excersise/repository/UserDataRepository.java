package com.test.excersise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.excersise.domain.User;
@Repository
public interface UserDataRepository extends JpaRepository<User, Integer>{

	@Transactional
	//@Modifying
	@Query(value = "select * from User where username=? and role =?" , nativeQuery = true)
	User findById(String userName , String role);

}
