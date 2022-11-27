package spring_boot_1.controller;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_boot_1.dto.EmployeeDtoRq;
import spring_boot_1.dto.ResultDto;
import spring_boot_1.service.EmployeeService;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Controller {
    EmployeeService employeeService;

    @PostMapping(path = "/createEmployee")
    public Integer createEmployee(@RequestBody EmployeeDtoRq employeeDtoRq) {
        return employeeService.createEmployee(employeeDtoRq);
    }

    @DeleteMapping(path = "/deleteEmployee/{id}")
    public ResultDto deleteEmployee(@PathVariable Integer id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping(path = "/getEmployee/{id}")
    public EmployeeDtoRq getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @PatchMapping(path = "/changeEmployee/{id}")
    public ResultDto changeEmployee(@RequestBody EmployeeDtoRq employeeDtoRq, @PathVariable Integer id) {
        return employeeService.changeEmployee(id, employeeDtoRq);
    }
}
