package com.harman.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="manager_id")
	@JsonBackReference
	private Emp manager;
	
	@Column(name = "manager_id", insertable  = false, updatable = false)
	private Integer idmanager;

	public Emp(String empFName, String empLName, String empPManager, String empDesignation, String empProject) {
		// TODO Auto-generated constructor stub
	}
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIdmanager() {
		return idmanager;
	}
	public void setIdmanager(Integer idmanager) {
		this.idmanager = idmanager;
	}
	
	public void setSubordinates(Set<Emp> subordinates) {
		this.subordinates = subordinates;
	}
	@OneToMany(mappedBy="manager",orphanRemoval = true)
	@JsonBackReference
	private Set<Emp> subordinates = new HashSet<Emp>();

	public Emp getManager() {
		return manager;
	}
	public void setManager(Emp manager) {
		this.manager = manager;
	}

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
				+ empPManager + ", empDesignation=" + empDesignation + ", manager=" + manager + ", subordinates="
				+ subordinates + ", empProject=" + empProject + "]";
	}
	
//	@Override
//	public String toString() {
//		return "Emp [empId=" + empId + ", empFName=" + empFName + ", empLName=" + empLName + ", empDesignation="
//				+ empDesignation + ", empProject=" + empProject + "]";
//	}
	
	//no argument constructor


}
