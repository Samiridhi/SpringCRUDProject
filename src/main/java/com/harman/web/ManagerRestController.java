package com.harman.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harman.Exception.EmployeeNotFoundException;

import com.harman.dao.ManagerRepo;
import com.harman.entity.Manager;
import com.harman.model.User;

@RestController
@RequestMapping("/manager")
@CrossOrigin(origins="http://localhost:4200")
public class ManagerRestController {

	@Autowired
	private ManagerRepo repo;
	
//	@RequestMapping(value="/viewall" , method=RequestMethod.GET)
	@GetMapping("/viewall")
	public List<Manager> viewManager(){
		List<Manager> mlist = repo.findAll();
//		Collections.sort((List<>) elist);
		return mlist;
	}
	
	@GetMapping("/viewall")
	@RequestMapping({ "/validateLogin" })
	public User validateLogin() {
		return new User("User successfully authenticated");
	}
	
	
//	@RequestMapping(value="/viewbyid" , method=RequestMethod.GET)
	@GetMapping("/viewbyid/{empid}")
	public Manager viewManager(@PathVariable("empid") int mid) throws EmployeeNotFoundException{
		Optional<Manager> optmanager = repo.findById(mid);
		if(optmanager.isEmpty()) 
			throw new EmployeeNotFoundException("Employee Manager not found for "+mid);
		Manager manager = optmanager.get();
		return manager;
	}
	
	
}
