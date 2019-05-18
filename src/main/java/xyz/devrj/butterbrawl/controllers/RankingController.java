package xyz.devrj.butterbrawl.controllers;

import xyz.devrj.butterbrawl.actions.Calculations;
import xyz.devrj.butterbrawl.actions.MapOrder;
import xyz.devrj.butterbrawl.entities.UserAccount;
import xyz.devrj.butterbrawl.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RankingController {
    private MainService service;

    @Autowired
    public RankingController(MainService service) {
        this.service = service;
    }


    /*
    *   List all group rankings
     */
    @GetMapping("/rankings")
    public String getRankings(Principal principal, Model model){
        String myUsername = principal.getName();
        UserAccount userAccount = service.loadAccount(myUsername);

        //Get ranking percents for the group
        List<String> names = service.getAllNames(userAccount.getGroupName());
        List<Integer> percents = Calculations.calculatePercents(
                service.getAllCurrentWeights(userAccount.getGroupName()),
                service.getAllStartingWeights(userAccount.getGroupName()
                ));
        Map<String, Integer> namesAndPercents = new LinkedHashMap<>(); //LinkedHashMap to keep input order
        for(int i = 0; i < names.size(); i++){
            namesAndPercents.put(names.get(i), percents.get(i));
        }

        //Reorder the map of names:percents in decscending order
        namesAndPercents = MapOrder.orderDescending(namesAndPercents);

        model.addAttribute("namesAndPercents", namesAndPercents);

        return "iframes/rankings";
    }
}
