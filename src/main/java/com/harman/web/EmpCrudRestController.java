package com.harman.web;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harman.Exception.EmployeeNotFoundException;
import com.harman.Exception.IdAlreadyExistsException;
import com.harman.dao.EmpRepo;
import com.harman.dto.EmpDto;
import com.harman.dto.SuccessMsg;
import com.harman.entity.Emp;

@RestController
@RequestMapping("/empcrud")
@CrossOrigin(origins="http://localhost:4200")
public class EmpCrudRestController {

	@Autowired
	private EmpRepo repo;
	Logger logger = LoggerFactory.logger(EmpRestController.class);
	
	@GetMapping("/viewbymanager")
	public List<Emp> viewEmployee(@RequestParam("manager") String manager){
		List<Emp> lst = repo.findByEmpPManager(manager);
		return lst;
	}
//	@GetMapping("/viewbyfirstname")
//	public List<Emp> viewEmployee1(@RequestParam("fname") String fname){
//		List<Emp> lst = repo.findByEmpPManager(fname);
//		return lst;
//	}
//	@GetMapping("/viewbylastname")
//	public List<Emp> viewEmployee2(@RequestParam("lname") String lname){
//		List<Emp> lst = repo.findByEmpPManager(lname);
//		return lst;
//	}
	
	@PostMapping("/addemp")
	public SuccessMsg addEmployee(@RequestBody EmpDto empdto) throws IdAlreadyExistsException, EmployeeNotFoundException {
		Optional<Emp> optemp = repo.findById(empdto.getEmpId());
		if(optemp.isPresent())
			throw new IdAlreadyExistsException("ID already exist");
		Emp emp = new Emp();
		emp.setEmpId(empdto.getEmpId());
		emp.setEmpFName(empdto.getEmpFName());
		emp.setEmpLName(empdto.getEmpLName());
		emp.setEmpPManager(empdto.getEmpPManager());
		emp.setEmpDesignation(empdto.getEmpDesignation());
		emp.setEmpProject(empdto.getEmpProject());
//		emp.setManager(emp);
		emp.setManager(manager(emp.getEmpPManager()));		
		repo.save(emp);
		return new SuccessMsg("Employee Added Successfully");
				
	}
	
	public Emp manager(String name) throws EmployeeNotFoundException {
		List<Emp> optemp = repo.findByEmpFName(name.toLowerCase());
		if(optemp.isEmpty()) 
			throw new EmployeeNotFoundException("Employee not found for "+ name);
		Emp emp = optemp.get(0);
		System.out.print(emp);
//		emp.setManager(emp);
		return emp;
	}
//	public SuccessMsg deletesubordinates(String name) throws EmployeeNotFoundException {
//		List<Emp> optemp = repo.findByEmpPManager(name.toLowerCase());
//		if(optemp.isEmpty()) 
//			throw new EmployeeNotFoundException("Employee not found for "+ name);
//		Emp emp = optemp.get(0);
//		System.out.print(emp);
//		repo.delete(emp);
////		emp.setManager(emp);
//		return new SuccessMsg("Employee Deleted");
//	}

	
	@DeleteMapping("/removeemp")
	public SuccessMsg removeEmployee(@RequestParam("empId") int eid) throws EmployeeNotFoundException {
		Optional<Emp> optemp = repo.findById(eid);
		if(optemp.isEmpty())
			throw new EmployeeNotFoundException("Employee not found");
		Emp emp = optemp.get();
		String managerid = emp.getEmpFName();
		logger.info(managerid);
		logger.info(emp);
//		deletesubordinates(managerid);
		repo.delete(emp);		
		return new SuccessMsg("Employee Deleted");
	}
	
	@PutMapping("/editemp")
	public SuccessMsg editEmployee(@RequestBody EmpDto empdto) throws EmployeeNotFoundException {
		Optional<Emp> optemp = repo.findById(empdto.getEmpId());
		if(optemp.isEmpty())
			throw new EmployeeNotFoundException("Employee not found");
		Emp emp = optemp.get();
		emp.setEmpFName(empdto.getEmpFName());
		emp.setEmpLName(empdto.getEmpLName());
		emp.setEmpPManager(empdto.getEmpPManager());
		emp.setEmpDesignation(empdto.getEmpDesignation());
		emp.setEmpProject(empdto.getEmpProject());
		emp.setManager(manager(emp.getEmpPManager()));	
		repo.save(emp);
		return new SuccessMsg("Employee Updated");
	}
	
}













