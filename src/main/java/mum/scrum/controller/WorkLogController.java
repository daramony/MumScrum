package mum.scrum.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.scrum.model.WorkLog;
import mum.scrum.service.UserStoryService;
import mum.scrum.service.WorkLogService;

@Controller
public class WorkLogController {
	
	@Autowired
	WorkLogService workLogService;
	@Autowired
	UserStoryService userStoryService;
	
	@RequestMapping(value = "/updateEffort/{id}", method = RequestMethod.GET)
	public String updateEffort(@ModelAttribute("workLog") WorkLog worklog, @PathVariable("id") Integer id, Model model,RedirectAttributes redirect) {
		model.addAttribute("userStoryId",id);
		return "updateEffort";
	}
	
	@RequestMapping(value = "/updateEffort/{id}", method = RequestMethod.POST)
	public String updateEffort(@ModelAttribute("workLog") WorkLog worklog,@PathVariable("id") Integer id,  BindingResult result, RedirectAttributes redirect) {
		worklog.setStatus("A");	
		worklog.setWorkDay(Calendar.getInstance().getTime());
		worklog.setUserStory(userStoryService.findUserStoryById(id));
		workLogService.saveWorkLog(worklog);
		redirect.addFlashAttribute("message", "Effort Updated successfully.");
		return "redirect:/estimateEffort";
	}
}
