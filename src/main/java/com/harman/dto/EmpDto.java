package com.harman.dto;



public class EmpDto {

	private int empId;
	private String empFName;
	private String empLName;
	private String empPManager;
	private String empDesignation;
	private String empProject;
	private Integer idmanager;
	private String gender;
	
	
	public Integer getIdmanager() {
		return idmanager;
	}
	public void setIdmanager(Integer idmanager) {
		this.idmanager = idmanager;
	}
	public String getEmpProject() {
		return empProject;
	}
	public void setEmpProject(String empProject) {
		this.empProject = empProject;
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
