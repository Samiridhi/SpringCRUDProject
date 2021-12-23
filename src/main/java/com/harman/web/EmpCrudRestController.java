package com.harman.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public SuccessMsg addEmployee(@RequestBody EmpDto empdto) throws IdAlreadyExistsException {
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
		
		repo.save(emp);
		return new SuccessMsg("Employee Added Successfully");
				
	}
	
	@DeleteMapping("/removeemp")
	public SuccessMsg removeEmployee(@RequestParam("empId") int eid) throws EmployeeNotFoundException {
		Optional<Emp> optemp = repo.findById(eid);
		if(optemp.isEmpty())
			throw new EmployeeNotFoundException("Employee not found");
		Emp emp = optemp.get();
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
		repo.save(emp);
		return new SuccessMsg("Employee Updated");
	}
	
}













