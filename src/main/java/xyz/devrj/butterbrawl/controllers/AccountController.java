package xyz.devrj.butterbrawl.controllers;

import xyz.devrj.butterbrawl.entities.UserAccount;
import xyz.devrj.butterbrawl.services.MainService;
import xyz.devrj.butterbrawl.temp_objects.TempUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class AccountController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private MainService service;

    @Autowired
    public AccountController(MainService service) {
        this.service = service;
    }



    /*=======================================
                Load Account Settings
    ======================================= */
    @GetMapping("/userAccount")
    public String getUserAccount(Principal principal, Model model){

        //Load Account Details
        String myUsername = principal.getName();
        UserAccount userAccount = service.loadAccount(myUsername);

        //Initialize all fields to auto-fill form (overloaded constructor)
        TempUser tempUser = new TempUser(userAccount);

        //Pass Account to model to construct view with user details
        model.addAttribute("tempUserAccount", tempUser);

        return "account_details";

    }

    /*=======================================
               Update User Details
    ======================================= */
    @PostMapping("/userAccount")
    public String postUserAccount(@Valid @ModelAttribute("tempUserAccount") TempUser tempUserAccount, BindingResult bindingResult, Model model){
        //Check for invalid form input fields
        if(bindingResult.hasErrors()){
            logger.info(">>>>>>>>>>BINDING ERROR: " + bindingResult.getAllErrors());
            logger.info(">>>>>>>>>>Details: " + tempUserAccount);
            return "account_details";
        }

        service.saveUpdateAccount(tempUserAccount);
        return "redirect:/";

    }


    /*=======================================
               DELETE USER
    ======================================= */
    @PostMapping("/deleteUser")
    public String delUserAccount(Principal principal){

        service.deleteAccount(principal);

        //Clear out the current session
        SecurityContextHolder.clearContext();
        return "redirect:/";

    }



}
