package com.sid.learn.controller;

import com.sid.learn.dto.EmployeeDto;
import com.sid.learn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value ="/employee")
    public ResponseEntity<EmployeeDto> getEmployee(@RequestParam("id") int id){
        EmployeeDto employeeDto = employeeService.getEmployee(id);
        return ResponseEntity.ok(employeeDto);
    }

    @PostMapping(value = "/employee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDtoResponse = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.ok(employeeDtoResponse);
    }

}
