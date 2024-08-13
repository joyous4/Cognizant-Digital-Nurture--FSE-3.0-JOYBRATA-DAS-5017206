package com.ems.EmployeeManagementSystem.dto;

public class EmployeeDTO {
    private Integer id;
    private String name;
    private String email;
    private String departmentName;

    public EmployeeDTO(Integer id, String name, String email, String departmentName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }
}
