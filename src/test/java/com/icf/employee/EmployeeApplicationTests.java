package com.icf.employee;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.icf.employee.repo.UserRepo;
import com.icf.employee.repo.UserRoleRepository;
import com.icf.employee.service.UserRoleService;
import com.icf.employee.service.UserService;

@SpringBootTest
class EmployeeApplicationTests {
	

	@Autowired
	DozerBeanMapper dozerBeanMapper;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRoleRepository userRoleRepo;
	
	@Autowired
	UserRoleService userRoleService;
	
	@Test
	void a() {
		System.out.println("Test started");
	}

	@Test
	void b() {
		System.out.println("Testing get user roles");
//		UserRoleDto userRoleDto = new UserRoleDto();
//		userRoleDto.setRoleId(Long.valueOf(1));
//		userRoleDto.setRoleDesc("Super Admin");
//		userRoleDto.setRoleName("Super Admin");
//		
//		UserRole userRole = dozerBeanMapper.map(userRoleDto, UserRole.class);
//		
//		Mockito.when(userRoleRepo.getOne((long) 1)).thenReturn(userRole);
//		assertThat(userRoleService.getUserRoleById((long) 1));
	}

	@Test
	void c() {
////		System.out.println("Testing save employee");
////		UserDto employeeDto = new UserDto();
////		UserRoleDto userRoleDto = new UserRoleDto();
////		userRoleDto.setRoleId(Long.valueOf(1));
////		employeeDto.setAddress("Bangalore");
////		employeeDto.setBloodGroup("O+ve");
////		employeeDto.setDepartment("Software");
////		employeeDto.setDesignation("Software Engineer");
////		employeeDto.setDob(LocalDate.now().toString());
////		employeeDto.setEmailId("hellen@gmail.com");
////		employeeDto.setEmployeeId(Long.valueOf(3));
////		employeeDto.setEmploymentId(Long.valueOf(10));
////		employeeDto.setEndDate("2021-04-15");
////		employeeDto.setFirstName("Hellen");
////		employeeDto.setGender("Female");
////		employeeDto.setLastName("Robert");
////		employeeDto.setReportingManager(Long.valueOf(1));
////		employeeDto.setStartDate("2020-05-12");
////		employeeDto.setStatus("Active");
////		employeeDto.setToken("token");
////		employeeDto.setUserName("hellen@gmail.com");
////		employeeDto.setUserPassword("Hellen@123");
////		employeeDto.setUserRole(userRoleDto);
////		
////		User employee = dozerBeanMapper.map(employeeDto, User.class);
////		
////		assertEquals(employeeDto.getEmployeeId(),employee.getEmployeeId());
////		assertEquals(employeeDto.getStatus(), employee.getStatus());
////		
////		Mockito.when(userRepo.save(employee)).thenReturn(employee);
////		assertThat(userService.createUser(employeeDto));
	}
	
	@Test
	void d() {
		System.out.println("Testing dependant");
	}
	
	@Test
	void e() {
		System.out.println("Testing qualification");
	}
}
