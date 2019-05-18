package xyz.devrj.butterbrawl.controllers;

import xyz.devrj.butterbrawl.entities.NewWeightLog;
import xyz.devrj.butterbrawl.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class WeightController {

    private MainService service;

    @Autowired
    public WeightController(MainService service) {
        this.service = service;
    }


    /*=======================================
                List all user weights
    ======================================= */
    @GetMapping("/weightLog")
    public String getWeightLog(Principal principal, Model model){
        String myUsername = principal.getName();

        //Get self weight logs
        model.addAttribute("myWeights", service.getAllWeightLogs(myUsername));

        //Store empty weightlog object for new entry
        model.addAttribute("newWeightLog", new NewWeightLog());

        return "iframes/weight_log";
    }



    /*=======================================
                LOG A NEW WEIGHT
    ======================================= */
    @PostMapping("/weightLog")
    public String logNewWeight(@ModelAttribute("newWeightLog") NewWeightLog newWeightLog, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            return "redirect:/weightLog";
        }

        service.addNewWeightLog(principal.getName(), newWeightLog.getLogWeight());
        return "redirect:/weightLog";
    }
}
