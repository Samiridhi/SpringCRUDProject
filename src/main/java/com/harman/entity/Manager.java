package com.harman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="Manager")
@DynamicUpdate
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Manager_id")
	private int managerId;
	
	@Column(name="manager_fname", nullable = false)
	private String managerFName;
	
	@Column(name="manager_lname")
	private String managerLName;
	
	@Column(name="manager_project")
	private String managerProject;

	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerFName() {
		return managerFName;
	}
	public void setManagerFName(String managerFName) {
		this.managerFName = managerFName;
	}
	public String getManagerLName() {
		return managerLName;
	}
	public void setManagerLName(String managerLName) {
		this.managerLName = managerLName;
	}
	public String getManagerProject() {
		return managerProject;
	}
	
	
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerFName=" + managerFName + ", managerLName=" + managerLName
				+ ", managerProject=" + managerProject + "]";
	}

}
