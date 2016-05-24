package mum.scrum.controller;

import mum.scrum.service.BurnDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by ishwor on 11/12/15.
 */
@Controller
public class BurnDownController {

    @Autowired
    BurnDownService burnDownService;
    @RequestMapping(value = "/generateBDChart/{sprintId}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,TreeMap<String, Integer>> generateBurnDown(@PathVariable("sprintId") int sprintId){
        return burnDownService.generateBurnDownData(sprintId);
    }

    @RequestMapping(value = "/generateBD/{sprintId}",method = RequestMethod.GET)
    public String burnDownPage(@PathVariable("sprintId") int sprintId,Model model){
        model.addAttribute("sprintId",sprintId);
        return "burnDownPage";
    }

}
