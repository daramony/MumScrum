package mum.scrum.controller;

import mum.scrum.model.Sprint;
import mum.scrum.service.ReleaseService;
import mum.scrum.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by ishwor on 11/16/15.
 */
@Controller
public class SprintController {

    @Autowired
    SprintService sprintService;
    @Autowired
    ReleaseService releaseService;

    @RequestMapping(value = "/addSprint",method = RequestMethod.GET)
    public String createSprint(@ModelAttribute("Sprint") Sprint sprint,Model model){
        model.addAttribute("releaseList",releaseService.findAllRelease());
        return "addSprint";
    }

    @RequestMapping(value = "/addSprint",method = RequestMethod.POST)
    public String addSprint(@Valid @ModelAttribute("Sprint") Sprint sprint, BindingResult result){
        if(result.hasErrors()){
            return "addSprint";
        }

        sprintService.saveSprint(sprint);
        return "redirect:/listSprint";
    }

    @RequestMapping(value = "/listSprint",method = RequestMethod.GET)
    public String listSprint(@ModelAttribute("Sprint") Sprint sprint, Model model){
        model.addAttribute("sprints",sprintService.findAllSprint());
        return "listSprint";
    }

    @RequestMapping(value = "/editSprint/{id}", method = RequestMethod.GET)
    public String editSprint(@PathVariable("id") Integer id, @ModelAttribute("Sprint") Sprint sprint,
                                Model model) {
        model.addAttribute("Sprint", sprintService.findSprintById(id));
        model.addAttribute("releaseList",releaseService.findAllRelease());
        return "addSprint";
    }

    @RequestMapping(value = "/deleteSprint/{id}", method = RequestMethod.GET)
    public String deleteSprint(@PathVariable("id") Integer id,RedirectAttributes redirect) {
        sprintService.deleteSprint(id);
        redirect.addFlashAttribute("message", "Sprint Deleted successfully.");
        return "redirect:/listSprint";
    }


}

