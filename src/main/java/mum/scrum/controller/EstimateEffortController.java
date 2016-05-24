package mum.scrum.controller;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.scrum.model.*;
import mum.scrum.service.EstimateEffortService;
import mum.scrum.service.UserStoryService;
import mum.scrum.utility.Utility;

@Controller
public class EstimateEffortController {
	
	@Autowired
	UserStoryService userStoryService;
	
	@Autowired
	EstimateEffortService estimateEffortService;
	
	@RequestMapping(value = "/estimateEffort", method = RequestMethod.GET)
	public String estimateEffort(Model model, HttpServletRequest request) {			
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(Utility.hasRole("ROLE_Developer")){
			model.addAttribute("userStories", estimateEffortService.findUserStoryByDev(estimateEffortService.findIdByUserName(userDetails.getUsername())));
		}
		else if(Utility.hasRole("ROLE_Tester")){
			model.addAttribute("userStories", estimateEffortService.findUserStoryByTester(estimateEffortService.findIdByUserName(userDetails.getUsername())));
		}
		return "estimateEffort";
	}
	
	@RequestMapping(value = "/calculateEffort/{id}", method = RequestMethod.GET)
	public String calculateEffort(Model model, @ModelAttribute("userStory") UserStory userStory, @PathVariable("id") Integer id) {
		return "calculateEffort";
	}	
	
	@RequestMapping(value = "/calculateEffort", method = RequestMethod.POST)
	public String saveEffort(HttpServletRequest request, @ModelAttribute("userStory") UserStory userStory,  BindingResult result, RedirectAttributes redirect) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(Utility.hasRole("ROLE_Developer")){
			estimateEffortService.estimateEffortDeveloper(userStory.getId(), estimateEffortService.findIdByUserName(userDetails.getUsername()),  userStory.getDevEffort());
		}
		else if(Utility.hasRole("ROLE_Tester")){
			estimateEffortService.estimateEffortTester(userStory.getId(), estimateEffortService.findIdByUserName(userDetails.getUsername()),  userStory.getTestEffort());
		}
		redirect.addFlashAttribute("message", "Effort Estimated successfully !!!");
		
		return "redirect:/estimateEffort";
	}
	
}
