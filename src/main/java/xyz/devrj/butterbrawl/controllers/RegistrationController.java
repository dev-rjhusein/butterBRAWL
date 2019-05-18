package xyz.devrj.butterbrawl.controllers;

import xyz.devrj.butterbrawl.email_templates.RegistrationTemplates;
import xyz.devrj.butterbrawl.entities.Group;
import xyz.devrj.butterbrawl.services.EmailServiceImpl;
import xyz.devrj.butterbrawl.services.MainService;
import xyz.devrj.butterbrawl.temp_objects.TempUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class RegistrationController {

    private final Logger logger = Logger.getLogger(getClass().getName());

    private MainService service;
    private EmailServiceImpl emailService;

    @Autowired
    public RegistrationController(MainService service, EmailServiceImpl emailService){
        this.service = service;
        this.emailService = emailService;
    }

    /*=======================================
         (GET) SIGN UP USER PAGE
    ======================================= */
    @GetMapping("/signup/user")
    public String getUserSignUp(Model model){

        //Send new TempUser to model for new user form
        model.addAttribute("newUser", new TempUser());
        return "signup_user";
    }

    /*=======================================
           (POST) PROCESS NEW USER
    ======================================= */
    @PostMapping("/signup/user")
    public String postUserSignUp(@Valid @ModelAttribute("newUser") TempUser newUser, BindingResult bindingResult, Model model){

        String userName = newUser.getUserName();
        logger.info(">>>>>>>>>>Registering: " +userName);

        //Check for any invalid input fields
        if(bindingResult.hasErrors()){
            logger.info(">>>>>>>>>>BINDING ERROR: " + bindingResult.getAllErrors());
            return "signup_user";
        }

        //Ensure Username is unique
        if(!service.getUsernameExists(userName)){
            logger.info(">>>>>>>Username '" + userName + "' is exists!");
            model.addAttribute("usernameExistsError", "That username exists already.");
            return "signup_user";
        }

        //Ensure GroupName is NOT unique (Must join existing group)
        String group = newUser.getGroupName();
        if(service.getGroupExists(group)){
            logger.info(">>>>>>>>>>Group name '" + group + "' doesn't exist!");
            model.addAttribute("groupNameError", "That group doesn't exist.");
            return "signup_user";
        }

        //Save account
        service.saveNewAccount(newUser);

        //Send confirmation email
        emailService.sendMessage(newUser.getEmail(), "Welcome to butterBRAWL!",
                RegistrationTemplates.getWelcomeUser(newUser.getUserName(), newUser.getFirstName(), newUser.getGroupName()));

        return "redirect:/";
    }
    /*=======================================
         (GET) SIGN UP GROUP PAGE
    ======================================= */
    @GetMapping("/signup/group")
    public String getGroupSignUp(Model model){
        model.addAttribute("pageTitle", "Group Signup");
        model.addAttribute("newGroup", new Group());

        return "signup_group";
    }

    /*=======================================
         (POST) PROCESS NEW GROUP
    ======================================= */
    @PostMapping("/signup/group")
    public String postGroupSignUp(@Valid @ModelAttribute("newGroup") Group newGroup, BindingResult bindingResult, Model model){
        model.addAttribute("pageTitle", "Group Signup");
        if(bindingResult.hasErrors()){
            logger.warning(">>>>>>>>>> Group signup bind has errors");
            return "signup_group";
        }
        if(!service.getGroupExists(newGroup.getGroupName())){
            logger.warning(">>>>>>>>>> Group already exists");
            logger.warning(">>>>>>>>>> Group "+newGroup.getGroupName()+" exists");
            model.addAttribute("groupTakenError", "That group name is already taken. Try another name.");
            return "signup_group";
        }

        service.addGroup(newGroup);
        return "redirect:/";
    }

}
