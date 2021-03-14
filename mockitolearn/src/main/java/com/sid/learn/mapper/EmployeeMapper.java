package com.sid.learn.mapper;

import com.sid.learn.dto.EmployeeDto;
import com.sid.learn.entiry.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper( EmployeeMapper.class );

    EmployeeDto toDto(EmployeeEntity employeeEntity);
    EmployeeEntity toEntity(EmployeeDto employeeDto);
}
