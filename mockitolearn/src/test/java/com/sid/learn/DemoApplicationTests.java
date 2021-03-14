package com.sid.learn;

import com.sid.learn.dto.EmployeeDto;
import com.sid.learn.mapper.EmployeeMapper;
import com.sid.learn.repository.EmployeeRepo;
import com.sid.learn.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	EmployeeService employeeService;

	@MockBean
	EmployeeRepo employeeRepo;

	@Test
	void testEmployeeSave() {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(101);
		employeeDto.setName("Issmat");

		Mockito.when(employeeRepo.save(EmployeeMapper.INSTANCE.toEntity(employeeDto))).thenReturn(EmployeeMapper.INSTANCE.toEntity(employeeDto));
		EmployeeDto employeeDto1 = employeeService.saveEmployee(employeeDto);
		System.out.println("Saved Employee: " + employeeDto1.toString());

		Mockito.verify(employeeRepo, Mockito.times(1)).save(EmployeeMapper.INSTANCE.toEntity(employeeDto));

	}

}
