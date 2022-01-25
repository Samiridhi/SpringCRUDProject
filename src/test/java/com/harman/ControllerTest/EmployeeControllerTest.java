package com.harman.ControllerTest;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.harman.dao.EmpRepo;
import com.harman.entity.Emp;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeControllerTest {

    @Autowired
    private EmpRepo employeeRepository;

    // JUnit test for saveEmployee
    @Test
    @Order(1)
//    @Rollback(value = false)
    public void saveEmployeeTest(){

    	Emp employee = employeeRepository.getById(163);
    	employee.setEmpFName("mehu");
    	employee.setEmpLName("wadhwa");
    	employee.setEmpDesignation("hr");
    	employee.setEmpProject("wow");
    	employee.setEmpPManager("bruce");
    	employeeRepository.save(employee);
        Assertions.assertThat(employee.getEmpId()).isEqualTo(employee.getEmpId());
    }

    @Test
    @Order(2)
    public void getEmployeeTest(){

        Emp employee = employeeRepository.findById(106).get();

        Assertions.assertThat(employee.getEmpId()).isEqualTo(106);

    }

    @Test
    @Order(3)
    public void getListOfEmployeesTest(){

        List<Emp> employees = employeeRepository.findAll();

        Assertions.assertThat(employees.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployeeTest(){

        Emp employee = employeeRepository.findById(163).get();

        employee.setEmpPManager("julia");

        Emp employeeUpdated =  employeeRepository.save(employee);

        Assertions.assertThat(employeeUpdated.getEmpPManager()).isEqualTo("julia");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){

        Emp employee = employeeRepository.findById(164).get();

        employeeRepository.delete(employee);

        Emp employee1 = null;

        Optional<Emp> optionalEmployee = employeeRepository.findById(163);

        if(optionalEmployee.isPresent()){
            employee1 = optionalEmployee.get();
        }

        Assertions.assertThat(employee1).isNull();
    }
    @Test
    @Order(6)
    public void getEmployeeByManagerTest(){

        Emp employee = employeeRepository.findByEmpPManager("lex").get(0);

        Assertions.assertThat(employee.getEmpPManager()).isEqualTo("lex");

    }
    @Test
    @Order(7)
    public void getEmployeeByDesignationTest(){

        List<Emp> employee = employeeRepository.findByEmpDesignation("ceo");

        Assertions.assertThat(employee).isNotNull();

    }

}
