package edu.icet.emp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.emp.dto.Employee;
import edu.icet.emp.entity.EmployeeEntity;
import edu.icet.emp.repository.EmployeeRepository;
import edu.icet.emp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository repository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public void addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = mapper.convertValue(employee, EmployeeEntity.class);
        repository.save(employeeEntity);
    }

    @Override
    public List<Employee> getAll() {
        Iterable<EmployeeEntity> getAll = repository.findAll();

        List<Employee> employeeList = new ArrayList<>();

        for (EmployeeEntity employeeEntity : getAll) {
            employeeList.add(mapper.convertValue(employeeEntity, Employee.class));
        }

        return employeeList;
    }

    @Override
    public void deleteEmpById(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}
