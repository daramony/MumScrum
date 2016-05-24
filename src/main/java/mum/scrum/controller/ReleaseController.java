package mum.scrum.controller;

import mum.scrum.model.Release;
import mum.scrum.model.UserStory;
import mum.scrum.service.ReleaseService;
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
public class ReleaseController {

    @Autowired
    ReleaseService releaseService;

    @RequestMapping(value = "/addRelease",method = RequestMethod.GET)
    public String createRelease(@ModelAttribute("release")Release relase){
        return "addRelease";
    }

    @RequestMapping(value = "/addRelease",method = RequestMethod.POST)
    public String saveRelease(@Valid @ModelAttribute("release")Release release, BindingResult result){
        if(result.hasErrors()){
            return "addRelease";
        }
        releaseService.saveRelease(release);
        return "redirect:/listRelease";
    }

    @RequestMapping(value = "/listRelease",method = RequestMethod.GET)
    public String listRelease(@ModelAttribute("release") Release release, Model model){
        model.addAttribute("releases",releaseService.findAllRelease());
        return "listRelease";
    }

    @RequestMapping(value = "/editRelease/{id}", method = RequestMethod.GET)
    public String editUserStory(@PathVariable("id") Integer id, @ModelAttribute("release") Release release,
                                Model model) {
        model.addAttribute("release", releaseService.findReleaseById(id));
        return "addRelease";
    }

    @RequestMapping(value = "/deleteRelease/{id}", method = RequestMethod.GET)
    public String deleteUserStory(@PathVariable("id") Integer id,RedirectAttributes redirect) {
        releaseService.deleteRelease(id);
        redirect.addFlashAttribute("message", "Release Deleted successfully.");
        return "redirect:/listRelease";
    }

}
