package edu.icet.emp.repository;

import edu.icet.emp.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
    EmployeeEntity findByFirstName(String firstName);
}
