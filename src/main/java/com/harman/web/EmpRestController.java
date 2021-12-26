package com.harman.web;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harman.Exception.EmployeeNotFoundException;
import com.harman.dao.EmpRepo;
import com.harman.entity.Emp;
import com.harman.model.User;

@RestController
@RequestMapping("/employee")
//angular url
@CrossOrigin(origins="http://localhost:4200")
public class EmpRestController {

	@Autowired
	private EmpRepo repo;
	
//	@RequestMapping(value="/viewall" , method=RequestMethod.GET)
	@GetMapping("/viewall")
	public List<Emp> viewEmployee(){
		List<Emp> elist = repo.findAll();
//		Collections.sort((List<>) elist);
		return elist;
	}
	
	@GetMapping("/viewall")
	@RequestMapping({ "/validateLogin" })
	public User validateLogin() {
		return new User("User successfully authenticated");
	}
	
	
//	@RequestMapping(value="/viewbyid" , method=RequestMethod.GET)
	@GetMapping("/viewbyid/{empid}")
	public Emp viewEmployee(@PathVariable("empid") int eid) throws EmployeeNotFoundException{
		Optional<Emp> optemp = repo.findById(eid);
		if(optemp.isEmpty()) 
			throw new EmployeeNotFoundException("Employee not found for "+eid);
		Emp emp = optemp.get();
		return emp;
	}
	
	@GetMapping("/viewbydesignation")
	public List<Emp> viewEmployee(@RequestParam("dname") String designation){
		List<Emp> lst = repo.findByEmpDesignation(designation);
		return lst;
	}
}







