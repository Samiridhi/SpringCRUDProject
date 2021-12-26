package com.harman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="ProjectEmployee")
@DynamicUpdate
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_fname", nullable = false)
	private String empFName;
	
	@Column(name="emp_lname")
	private String empLName;
	
	@Column(name="emp_projManager")
	private String empPManager;
	
	@Column(name="emp_designation")
	private String empDesignation;
	
	public String getEmpProject() {
		return empProject;
	}
	public void setEmpProject(String empProject) {
		this.empProject = empProject;
	}
	@Column(name="emp_project")
	private String empProject;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpFName() {
		return empFName;
	}
	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}
	public String getEmpLName() {
		return empLName;
	}
	public void setEmpLName(String empLName) {
		this.empLName = empLName;
	}
	public String getEmpPManager() {
		return empPManager;
	}
	public void setEmpPManager(String empPManager) {
		this.empPManager = empPManager;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empFName=" + empFName + ", empLName=" + empLName + ", empPManager="
				+ empPManager + ", empDesignation=" + empDesignation + "]";
	}
	
	//no argument constructor


}
