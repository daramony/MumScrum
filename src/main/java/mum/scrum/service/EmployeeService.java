package mum.scrum.service;

import java.util.List;

import mum.scrum.model.Employee;
import mum.scrum.model.EmployeeRole;

public interface EmployeeService{
	
	public Employee findEmployeeById(Integer id);
	
	public Employee findEmployeeByUserId(String id);
	
	public boolean saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public boolean deleteEmployee(Integer id);
	
	public void assignEmployeeRoles(List<EmployeeRole> roles, Employee employee);
	
	public List<Employee> getEmployeeByRoles(String roleName);
	
}
