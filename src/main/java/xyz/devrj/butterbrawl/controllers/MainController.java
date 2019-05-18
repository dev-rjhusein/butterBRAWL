package xyz.devrj.butterbrawl.controllers;

import xyz.devrj.butterbrawl.entities.UserAccount;
import xyz.devrj.butterbrawl.services.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //    Automatically trim whitespace on any input in data binder
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
//    DAO Service
    private MainService service;

    @Autowired
    public MainController(MainService service) {
        this.service = service;
    }

    /*=======================================
                LOAD THE DASHBOARD
    ======================================= */
    @RequestMapping("/")
    public String getDashboard(Principal principal, Model model){
        String myUsername = principal.getName();

        //Get username
        model.addAttribute("myUsername", myUsername);

        //Get account info
        UserAccount userAccount = service.loadAccount(myUsername);
        model.addAttribute("myAccount", userAccount);

        //Get self weight logs
        model.addAttribute("myWeights", service.getAllWeightLogs(myUsername));

        return "dashboard";
    }

    /*=======================================
                LOGIN PAGE
    ======================================= */
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }



}
