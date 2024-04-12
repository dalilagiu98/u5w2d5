package dalilagiurgola9.U5W2D5.repositories;

import dalilagiurgola9.U5W2D5.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {
    boolean existByEmail(String email);
    Optional<Employee> findByEmail(String email);
}
