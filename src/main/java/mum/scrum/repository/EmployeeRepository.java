package mum.scrum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mum.scrum.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT e FROM Employee e WHERE LOWER(e.userId) = LOWER(:userId)")
    public Employee findByUserId(@Param("userId") String userId);
	
	@Query("SELECT e FROM Employee e INNER JOIN e.employeeRoles er WHERE er.roleName = :roleName")
	public List<Employee> getEmployeeByRole(@Param("roleName") String roleName);
	
}
