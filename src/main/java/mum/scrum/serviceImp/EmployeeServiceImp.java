package mum.scrum.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.scrum.model.Employee;
import mum.scrum.model.EmployeeRole;
import mum.scrum.repository.EmployeeRepository;
import mum.scrum.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee findEmployeeByUserId(String id) {
		return employeeRepository.findByUserId(id);
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return true;
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public boolean deleteEmployee(Integer id) {
		employeeRepository.delete(id);
		return true;
	}

	@Override
	public void assignEmployeeRoles(List<EmployeeRole> roles, Employee employee) {
		employee.setEmployeeRoles(roles);
	}

	@Override
	public List<Employee> getEmployeeByRoles(String roleName){
		return employeeRepository.getEmployeeByRole(roleName);
	}
	
}


