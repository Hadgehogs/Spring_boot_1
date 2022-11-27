package spring_boot_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring_boot_1.dao.EmployeeDao;
import spring_boot_1.dto.EmployeeDtoRq;
import spring_boot_1.dto.ResultDto;
import spring_boot_1.entity.Employee;
import spring_boot_1.mapper.EmployeeMapper;

@Component
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeDao employeeDao;
    public Integer createEmployee(EmployeeDtoRq employeeDtoRq){
        Employee employee = employeeMapper.convertEmployeeDtoRq(employeeDtoRq);
        return employeeDao.createEmployee(employee);
    }
    public ResultDto deleteEmployee(Integer id){
        return employeeDao.deleteEmployee(id);
    }

    public EmployeeDtoRq getEmployee(Integer id){
        Employee employee = employeeDao.getEmployee(id);
        EmployeeDtoRq employeeDtoRq = employeeMapper.convertEmployee(employee);
        return employeeDtoRq;
    }

    public ResultDto changeEmployee(Integer id,EmployeeDtoRq employeeDtoRq){
        Employee employee = employeeMapper.convertEmployeeDtoRq(employeeDtoRq);
        return employeeDao.changeEmployee(id, employee);
    }
}
