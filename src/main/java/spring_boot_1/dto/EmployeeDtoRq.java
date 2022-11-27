package spring_boot_1.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class EmployeeDtoRq {
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private Double salary;
}
