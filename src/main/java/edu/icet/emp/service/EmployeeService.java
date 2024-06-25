package edu.icet.emp.service;

import edu.icet.emp.dto.Employee;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee);

    public List<Employee> getAll();

    void deleteEmpById(Long id);

    void updateEmployee(Employee employee);

    Employee findById(Long id);

    Employee findByFirstName(String firstName);
}
