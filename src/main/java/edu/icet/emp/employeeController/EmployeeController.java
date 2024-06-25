package edu.icet.emp.employeeController;

import edu.icet.emp.dto.Employee;
import edu.icet.emp.service.EmployeeService;
import edu.icet.emp.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
public class EmployeeController {

   final EmployeeService service;

    @PostMapping("add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }

    @GetMapping("get-all")
    public List<Employee> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete-emp/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteEmp(@PathVariable Long id){
        service.deleteEmpById(id);
    }

    @PutMapping("update-emp")
    public void updateEmployee(@RequestBody Employee employee){
        service.updateEmployee(employee);
    }

    @GetMapping("/find-by-id/{id}")
    public Employee findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/find-by-firstName/{firstName}")
    public Employee findByFirstName(@PathVariable String firstName){
        return service.findByFirstName(firstName);
    }

}
