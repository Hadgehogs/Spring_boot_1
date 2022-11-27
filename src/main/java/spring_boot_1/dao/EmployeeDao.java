package spring_boot_1.dao;

import org.springframework.stereotype.Component;
import spring_boot_1.dto.ResultDto;
import spring_boot_1.entity.Employee;

import java.util.HashMap;

@Component
public class EmployeeDao {
    private Integer idCounter=0;
    private HashMap<Integer, Employee> EmployeeTable=new HashMap<Integer, Employee>();

    public Integer createEmployee(Employee employee){
        idCounter++;
        EmployeeTable.put(idCounter,employee);
        employee.setId(idCounter);
        return idCounter;
    }

    public ResultDto deleteEmployee(Integer id){
        ResultDto resultDto=new ResultDto();
        if (!EmployeeTable.containsKey(id)){
            resultDto.setDescription(String.format("Для данного ID=%s не найден работник", id));
            resultDto.setResult(false);
            return resultDto;
        }
        EmployeeTable.remove(id);
        return resultDto;
    }

    public Employee getEmployee(Integer id){
        if (!EmployeeTable.containsKey(id)){
            return null;
        }
        return EmployeeTable.get(id);
    }

    public ResultDto changeEmployee(Integer id, Employee employee){
        ResultDto resultDto=new ResultDto();
        if (!EmployeeTable.containsKey(id)){
            resultDto.setDescription(String.format("Для данного ID=%s не найден работник", id));
            resultDto.setResult(false);
            return resultDto;
        }
        Employee currentEmployee=EmployeeTable.get(id);
        currentEmployee.setName(employee.getName());
        currentEmployee.setAge(employee.getAge());
        currentEmployee.setSalary(employee.getSalary());

        return resultDto;
    }

}
