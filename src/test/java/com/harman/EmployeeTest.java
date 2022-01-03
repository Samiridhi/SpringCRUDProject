//package com.harman;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.harman.dao.EmpRepo;
//import com.harman.entity.Emp;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class EmployeeTest extends SpringCrudProjectApplicationTests{
//
//	@Autowired
//	private EmpRepo repo;
//	
//	@Test
//	public void testCreateEmployee() {
//		Emp emp = new Emp(999,"FFF","LLL","PPP","Head","ABC");
//		repo.save(emp);
//	}
//}
