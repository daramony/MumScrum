package mum.scrum.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.scrum.model.Employee;
import mum.scrum.model.EmployeeRole;
import mum.scrum.service.EmployeeService;
import mum.scrum.utility.Utility;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/employee/list", method=RequestMethod.GET)
	public String listEmployee(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "listEmployee";
	}

	@RequestMapping(value="/employee/create", method=RequestMethod.GET)
	public String createEmployee() {
		return "createEmployee";
	}
	
	@RequestMapping(value="/employee/submitCreate", method=RequestMethod.POST)
	public String submitCreateEmployee(@Valid @ModelAttribute("employee") Employee employee, 
			BindingResult result,
			@RequestParam(value="employeeRole", required=false) String[] employeeRoles,  
			Model model, 
			HttpServletRequest request, 
			RedirectAttributes redirect) {
		
		if(result.hasErrors() && employeeRoles == null){
			return "createEmployee";
		}
		
		List<EmployeeRole> rolesList = new ArrayList<EmployeeRole>();
		if(employeeRoles != null){
			rolesList = Utility.getEmployeeRoles(employeeRoles, employee);
		}
		else{
			rolesList = Utility.cloneEmployeeRole(employeeService.findEmployeeById(employee.getId()).getEmployeeRoles(), employee);
		}
		
		employeeService.assignEmployeeRoles(rolesList, employee);
		employeeService.saveEmployee(employee);
		
		redirect.addFlashAttribute("message", "Save Success");
		
		return "redirect:/employee/list";
	}
	
	@RequestMapping(value="/employee/edit/{id}", method=RequestMethod.GET)
	public String editEmployee(@PathVariable("id") Integer id, Model model){
		Employee emp = employeeService.findEmployeeById(id);
		boolean isHR = Utility.checkRole(emp.getEmployeeRoles(), "ROLE_HRAdmin");
		boolean isSM = Utility.checkRole(emp.getEmployeeRoles(), "ROLE_ScrumMaster");
		boolean isDev = Utility.checkRole(emp.getEmployeeRoles(), "ROLE_Developer");
		boolean isTest = Utility.checkRole(emp.getEmployeeRoles(), "ROLE_Tester");
	
		model.addAttribute("isHR", isHR);
		model.addAttribute("isSM", isSM);
		model.addAttribute("isDev", isDev);
		model.addAttribute("isTest", isTest);
		model.addAttribute("employee", emp);
		return "createEmployee";
	}
	
	@RequestMapping(value="/employee/delete/{id}", method=RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") Integer id, RedirectAttributes redirect){
		employeeService.deleteEmployee(id);
		redirect.addFlashAttribute("message", "Delete Success");
		return "redirect:/employee/list";
	}
	
	@RequestMapping(value="/employee/read/{id}", method=RequestMethod.GET)
	public String readEmployee(@PathVariable("id") Integer id, Model model){
		Employee emp = employeeService.findEmployeeById(id);
		boolean isHR = Utility.checkRole(emp.getEmployeeRoles(), "ROLE_HRAdmin");
		boolean isSM = Utility.checkRole(emp.getEmployeeRoles(), "ROLE_ScrumMaster");
		boolean isDev = Utility.checkRole(emp.getEmployeeRoles(), "ROLE_Developer");
		boolean isTest = Utility.checkRole(emp.getEmployeeRoles(), "ROLE_Tester");
	
		model.addAttribute("isHR", isHR);
		model.addAttribute("isSM", isSM);
		model.addAttribute("isDev", isDev);
		model.addAttribute("isTest", isTest);
		model.addAttribute("employee", emp);
		return "readEmployee";
	}
	
	@RequestMapping(value="/update-profile", method=RequestMethod.GET)
	public String updateProfile(Model model){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("employee", employeeService.findEmployeeByUserId(userDetails.getUsername()));
		return "updateProfile";
	}
	
	@RequestMapping(value="/updateProfilePost", method=RequestMethod.POST)
	public String updateProfilePost(@ModelAttribute("employee") Employee employee, 
			BindingResult result, 
			Model model, RedirectAttributes redirect){
		
		Employee emp = employeeService.findEmployeeById(employee.getId());
		List<EmployeeRole> rolesList = Utility.cloneEmployeeRole(emp.getEmployeeRoles(), employee);
		employee.setEmployeeRoles(rolesList);
		employee.setUserId(emp.getUserId());
		employee.setEnabled(emp.getEnabled());
		employeeService.saveEmployee(employee);
		
		redirect.addFlashAttribute("message", "Update Success");
		
		return "redirect:/update-profile";
	}
	
}
