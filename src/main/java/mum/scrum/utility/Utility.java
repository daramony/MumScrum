package mum.scrum.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import mum.scrum.model.Developer;
import mum.scrum.model.Employee;
import mum.scrum.model.EmployeeRole;
import mum.scrum.model.HRAdmin;
import mum.scrum.model.ScrumMaster;
import mum.scrum.model.Tester;

public class Utility {

	public static List<EmployeeRole> getEmployeeRoles(String[] roles, Employee employee) {
		List<EmployeeRole> rolesList = new ArrayList<EmployeeRole>();
		if(roles.length > 0) {
				for(String r: roles) {
					if (r.toLowerCase().equals("1")) {
						HRAdmin hradmin = new HRAdmin();
						hradmin.setEmployee(employee);
						hradmin.setRoleName("ROLE_HRAdmin");
						rolesList.add(hradmin);
					}else if(r.toLowerCase().equals("2")) {
						ScrumMaster scrumMaster = new ScrumMaster();
						scrumMaster.setEmployee(employee);
						scrumMaster.setRoleName("ROLE_ScrumMaster");
						rolesList.add(scrumMaster);
					}else if(r.toLowerCase().equals("3")) {
						Developer developer = new Developer();
						developer.setEmployee(employee);
						developer.setRoleName("ROLE_Developer");
						rolesList.add(developer);
					}else if(r.toLowerCase().equals("4")) {
						Tester tester = new Tester();
						tester.setEmployee(employee);
						tester.setRoleName("ROLE_Tester");
						rolesList.add(tester);
					}
				}
		}
		return rolesList;
	}
	
	public static List<EmployeeRole> cloneEmployeeRole(List<EmployeeRole> roleList, Employee employee) {
		List<EmployeeRole> finalRoles = new ArrayList<EmployeeRole>();
		for(EmployeeRole r: roleList) {
			if(r.getClass().equals(HRAdmin.class)) {
				HRAdmin hradmin = new HRAdmin();
				hradmin.setEmployee(employee);
				hradmin.setRoleName("ROLE_HRAdmin");
				finalRoles.add(hradmin);
			}else if(r.getClass().equals(Tester.class)) {
				Tester tester = new Tester();
				tester.setEmployee(employee);
				tester.setRoleName("ROLE_Tester");
				finalRoles.add(tester);
			}else if(r.getClass().equals(Developer.class)) {
				Developer developer = new Developer();
				developer.setEmployee(employee);
				developer.setRoleName("ROLE_Developer");
				finalRoles.add(developer);
			}else if(r.getClass().equals(ScrumMaster.class)) {
				ScrumMaster scrumMaster = new ScrumMaster();
				scrumMaster.setEmployee(employee);
				scrumMaster.setRoleName("ROLE_ScrumMaster");
				finalRoles.add(scrumMaster);
			}
		}
		return finalRoles;
	}

	public static boolean hasRole(String role) {
		  Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		  boolean hasRole = false;
		  for (GrantedAuthority authority : authorities) {
		     hasRole = authority.getAuthority().equals(role);
		     if (hasRole) {
			  break;
		     }
		  }
		  return hasRole;
		}
	
	public static boolean checkRole(List<EmployeeRole> roles, String role) {
		for (EmployeeRole r : roles) {
			if (role.equals(r.getRoleName())) {
				return true;
			}
		}
		return false;
	}

}
