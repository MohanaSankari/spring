package com.test.excersise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.excersise.model.Task;
@Repository
public interface TaskDataRepository extends JpaRepository<Task, Long>{

	@Transactional
	@Modifying
	@Query(value= "update Task set completed=? where id=? and user_name=?",nativeQuery = true)
	void taskStatus(boolean completed, long id,String userName);

	@Transactional
	@Modifying
	@Query(value= "update Task set assigned_user=2 where id=? and user_name=?",nativeQuery = true)
	void taskAssignment(long id, String userName);

	@Transactional
	@Query(value= "select * from Task where assigned_user=2",nativeQuery = true)
	List<Task> findById();
	

}
