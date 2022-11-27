package spring_boot_1.mapper;

import org.springframework.stereotype.Component;
import spring_boot_1.dao.EmployeeDao;
import spring_boot_1.dto.EmployeeDtoRq;
import spring_boot_1.entity.Employee;

@Component
public class EmployeeMapper {

    private EmployeeDao employeeDao;

    public Employee convertEmployeeDtoRq(EmployeeDtoRq employeeDtoRq) {
        return new Employee(employeeDtoRq.getName(),employeeDtoRq.getAge(),employeeDtoRq.getSalary());
    }

    public EmployeeDtoRq convertEmployee(Employee employee) {
        if (employee==null){
            return null;
        }
        return new EmployeeDtoRq(employee.getName(),employee.getAge(),employee.getSalary());
    }
}
