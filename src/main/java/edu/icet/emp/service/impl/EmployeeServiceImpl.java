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
import java.util.Optional;

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

    @Override
    public void updateEmployee(Employee employee) {
        if (repository.findById(employee.getId()).isPresent()) {
            repository.save(mapper.convertValue(employee, EmployeeEntity.class));
        }
    }

    @Override
    public Employee findById(Long id) {
        if (repository.findById(id).isPresent()){
            Optional<EmployeeEntity> byId = repository.findById(id);
            return mapper.convertValue(byId.get(), Employee.class);
        }
        return new Employee();
    }

    @Override
    public Employee findByFirstName(String firstName) {
        return mapper.convertValue(repository.findByFirstName(firstName), Employee.class);
    }
}
