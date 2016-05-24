package mum.scrum.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.set.ListOrderedSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.scrum.model.Employee;
import mum.scrum.model.EmployeeRole;
import mum.scrum.model.Sprint;
import mum.scrum.model.UserStory;
import mum.scrum.model.WorkLog;
import mum.scrum.repository.EmployeeRepository;
import mum.scrum.repository.SprintRepository;
import mum.scrum.repository.UserStoryRepository;
import mum.scrum.utility.Utility;

@Service
public class DBLoader {


	@Autowired
	UserStoryRepository userStoryRepository;

	@Autowired
	SprintRepository sprintRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;

	@PostConstruct
	public void init(){

		WorkLog w1 = new WorkLog();
		w1.setRemainingDevEffort(90);
		w1.setRemainingTestEffort(40);
		w1.setWorkDay(new Date());

		WorkLog w3 = new WorkLog();
		w3.setRemainingDevEffort(80);
		w3.setRemainingTestEffort(35);
		w3.setWorkDay(new Date());

		WorkLog w4 = new WorkLog();
		w4.setRemainingDevEffort(70);
		w4.setRemainingTestEffort(30);
		w4.setWorkDay(new Date());

		WorkLog w5 = new WorkLog();
		w5.setRemainingDevEffort(70);
		w5.setRemainingTestEffort(30);
		w5.setWorkDay(new Date());

		WorkLog w2 = new WorkLog();
		w2.setRemainingDevEffort(75);
		w2.setRemainingDevEffort(25);
		w2.setWorkDay(new Date());


		UserStory userStory = new UserStory();
		userStory.setName("Test User Story");
		userStory.setDescription("This is a test user story description. This may be long but not good.");
		userStory.addWorkLog(w1);
		userStory.addWorkLog(w2);
		userStory.addWorkLog(w3);
		userStory.addWorkLog(w4);
		userStory.addWorkLog(w5);
		//userStoryRepository.save(userStory);

		UserStory userStory1 = new UserStory();
		userStory1.setName("Test User Story2");
		userStory1.setDescription("This is a test user story description2. This may be long but not good2.");
		userStory1.addWorkLog(w2);
		//userStory.setSprint(userStory1);

		//userStoryRepository.save(userStory1);

		Sprint sprint = new Sprint();
		sprint.setName("First Sprint");
		sprint.setStartDate(new Date());
		sprint.setEndDate(new Date());

		Set<UserStory> userStorySet = new ListOrderedSet();
		userStorySet.add(userStory);
		userStorySet.add(userStory1);
		sprint.setUserStorySet(userStorySet);
		
		if(employeeRepository.findAll().size() == 0) {
			
			Employee admin = new Employee();
			admin.setUserId("admin");
			admin.setPassword("admin");
			admin.setFirstName("Admin");
			admin.setLastName("Admin");
			admin.setEnabled(true);
			String[] lst = new String[]{"1","2","3","4"};
			List<EmployeeRole> roles = Utility.getEmployeeRoles(lst, admin);
			admin.setEmployeeRoles(roles);
			employeeRepository.save(admin);
			
			Employee hr = new Employee();
			hr.setUserId("hr");
			hr.setPassword("hr");
			hr.setFirstName("hr");
			hr.setLastName("hr");
			hr.setEnabled(true);
			String[] lst5 = new String[]{"1"};
			List<EmployeeRole> roles5 = Utility.getEmployeeRoles(lst5, hr);
			hr.setEmployeeRoles(roles5);
			employeeRepository.save(hr);
			
			Employee dev = new Employee();
			dev.setUserId("dev");
			dev.setPassword("dev");
			dev.setFirstName("dev");
			dev.setLastName("dev");
			dev.setEnabled(true);
			String[] lst2 = new String[]{"3"};
			List<EmployeeRole> roles2 = Utility.getEmployeeRoles(lst2, dev);
			dev.setEmployeeRoles(roles2);
			employeeRepository.save(dev);
			
			Employee sm = new Employee();
			sm.setUserId("sm");
			sm.setPassword("sm");
			sm.setFirstName("sm");
			sm.setLastName("sm");
			sm.setEnabled(true);
			String[] lst3 = new String[]{"2"};
			List<EmployeeRole> roles3 = Utility.getEmployeeRoles(lst3, sm);
			sm.setEmployeeRoles(roles3);
			employeeRepository.save(sm);
			
			Employee test = new Employee();
			test.setUserId("test");
			test.setPassword("test");
			test.setFirstName("test");
			test.setLastName("test");
			test.setEnabled(true);
			String[] lst4 = new String[]{"4"};
			List<EmployeeRole> roles4 = Utility.getEmployeeRoles(lst4, test);
			test.setEmployeeRoles(roles4);
			employeeRepository.save(test);
		}
		
		
		
		
//		sprintRepository.save(sprint);
	}
}
