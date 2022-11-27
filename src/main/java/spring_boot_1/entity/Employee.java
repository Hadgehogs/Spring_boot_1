package spring_boot_1.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class Employee {
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private Double salary;
}
