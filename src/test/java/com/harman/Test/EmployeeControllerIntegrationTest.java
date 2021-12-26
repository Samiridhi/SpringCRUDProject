package com.harman.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.harman.SpringCrudProjectApplication;
import com.harman.entity.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCrudProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest {
     @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void contextLoads() {

     }

     @Test
     public void testGetAllEmployees() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employee/viewall",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetEmployeeById() {
        Emp employee = restTemplate.getForObject(getRootUrl()+"/employee/", Emp.class);
        System.out.println(employee.getEmpId());
        assertNotNull(employee);
    }

    @Test
    public void testCreateEmployee() {
        Emp employee = new Emp();
        employee.setEmpId(999);
        employee.setEmpFName("admin");
        employee.setEmpLName("admin");
        ResponseEntity<Emp> postResponse = restTemplate.postForEntity(getRootUrl() + "/empcrud/add", employee, Emp.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateEmployee() {
        int id = 1;
        Emp employee = restTemplate.getForObject(getRootUrl() + "/empcrud/edit/" + id, Emp.class);
        employee.setEmpFName("admin1");
        employee.setEmpLName("admin2");
        restTemplate.put(getRootUrl() + "/empcrud/edit/" + id, employee);
        Emp updatedEmployee = restTemplate.getForObject(getRootUrl() + "/empcrud/edit/" + id, Emp.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void testDeleteEmployee() {
         int id = 123;
         Emp employee = restTemplate.getForObject(getRootUrl() + "/empcrud/delete/" + id, Emp.class);
         assertNotNull(employee);
         restTemplate.delete(getRootUrl() + "/empcrud/delete/" + id);
         try {
              employee = restTemplate.getForObject(getRootUrl() + "/empcrud/delete/" + id, Emp.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}
