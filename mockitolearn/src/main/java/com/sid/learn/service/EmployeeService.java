package com.sid.learn.service;

import com.sid.learn.dto.EmployeeDto;
import com.sid.learn.entiry.EmployeeEntity;
import com.sid.learn.mapper.EmployeeMapper;
import com.sid.learn.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeDto getEmployee(int id){
        EmployeeEntity employeeEntity = employeeRepo.findById(id).get();
        return EmployeeMapper.INSTANCE.toDto(employeeEntity);
    }

    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = employeeRepo.save(EmployeeMapper.INSTANCE.toEntity(employeeDto));
        return EmployeeMapper.INSTANCE.toDto(employeeEntity);
    }
}
