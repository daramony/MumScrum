package mum.scrum.controller;

import javax.validation.Valid;

import mum.scrum.model.WorkLog;
import mum.scrum.service.WorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import mum.scrum.model.UserStory;
import mum.scrum.service.EmployeeService;
import mum.scrum.service.SprintService;
import mum.scrum.service.UserStoryService;

@Controller
public class UserStoryController {

	@Autowired
	UserStoryService userStoryService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	SprintService sprintService;
	@Autowired
	WorkLogService workLogService;

	@RequestMapping(value = "/addUserStory", method = RequestMethod.GET)
	public String addUserStory(@ModelAttribute("userStory") UserStory userStory, Model model) {
		model.addAttribute("sprintList", sprintService.findAllSprint());
		model.addAttribute("developerList", employeeService.getEmployeeByRoles("ROLE_Developer"));
		model.addAttribute("testerList", employeeService.getEmployeeByRoles("ROLE_Tester"));
		return "addUserStory";
	}

	@RequestMapping(value = "/editUserStory/{id}", method = RequestMethod.GET)
	public String editUserStory(@PathVariable("id") Integer id, @ModelAttribute("userStory") UserStory userStory,
			Model model) {
		model.addAttribute("sprintList", sprintService.findAllSprint());
		model.addAttribute("developerList", employeeService.getEmployeeByRoles("ROLE_Developer"));
		model.addAttribute("testerList", employeeService.getEmployeeByRoles("ROLE_Tester"));
		model.addAttribute("userStory", userStoryService.findUserStoryById(id));
		return "addUserStory";
	}
	
	@RequestMapping(value = "/deleteUserStory/{id}", method = RequestMethod.GET)
	public String deleteUserStory(@PathVariable("id") Integer id,RedirectAttributes redirect) {
		UserStory userStory=userStoryService.findUserStoryById(id);
//		System.out.println(userStory.getWorkLogList());

		for(WorkLog workLog:userStory.getWorkLogList()){
			System.out.println(workLog.getId());
			workLogService.deleteWorkLog(workLog.getId());
		}
		userStoryService.deleteUserStory(id);
		redirect.addFlashAttribute("message", "User Deleted successfully.");
		return "redirect:/listUserStory";
	}
	
	@RequestMapping(value = "/addUserStory", method = RequestMethod.POST)
	public String saveUserStory(@Valid @ModelAttribute("userStory") UserStory userStory, BindingResult result) {
		if (result.hasErrors()) {
			return "addUserStory";
		}

		userStoryService.saveUserStory(userStory);
		return "redirect:/listUserStory";
	}

	@RequestMapping(value = "/listUserStory", method = RequestMethod.GET)
	public String listUser(Model model) {
		model.addAttribute("userStories", userStoryService.findAllUserStory());
		return "listUserStory";
	}
	
}
