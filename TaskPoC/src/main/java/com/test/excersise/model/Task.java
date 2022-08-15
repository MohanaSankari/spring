package com.test.excersise.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {
	@Id  
	//@GeneratedValue
	private long id; 
	private int createdBy;
	private int assignedUser;
	private Date createdAt;
	private Date completedAt;
	private String title;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	private String userName;
	private boolean completed;
	
	
	public Task(long id, int createdBy, int assignedUser, Date createdAt, Date completedAt, String title,Role role,
			String userName,boolean completed) {
		this.id = id;
		this.createdBy = createdBy;
		this.assignedUser = assignedUser;
		this.createdAt = createdAt;
		this.completedAt = completedAt;
		this.title = title;
		this.role=role;
		this.userName=userName;
		this.completed = completed;
	}
	
	public Task() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public int getAssignedUser() {
		return assignedUser;
	}
	public void setAssignedUser(int assignedUser) {
		this.assignedUser = assignedUser;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getCompletedAt() {
		return completedAt;
	}
	public void setCompletedAt(Date completedAt) {
		this.completedAt = completedAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
