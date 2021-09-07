package tech.atk.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tech.atk.employeemanager.model.Employee;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeById(Long id);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM Employee e ORDER BY e.id DESC LIMIT 3", nativeQuery = true)
    List<Employee> getLastEmployee();
}
