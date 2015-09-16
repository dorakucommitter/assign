package com.dorakucommitters.assign.web;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class AssignController {

    @RequestMapping(method = RequestMethod.GET)
    String list(Principal principal, Model model) {
    	addAttributeUserName(principal, model);

        return "assign/hotentry";
    }

    @RequestMapping(value = "assign/login")
    public String login() {
        return "assign/login";
    }

    @RequestMapping(value = "assign/logout")
    public String logout() {
        return "assign/logout";
    }

    @RequestMapping(value = "assign/searchskill")
    public String searchSkill(Principal principal, Model model) {
    	addAttributeUserName(principal, model);
        return "assign/searchskill";
    }

    @RequestMapping(value = "assign/searchproject")
    public String searchProject(Principal principal, Model model) {
    	addAttributeUserName(principal, model);
        return "assign/searchproject";
    }

    @RequestMapping(value = "assign/mastermaintenance")
    public String masterMaintenance(Principal principal, Model model) {
    	addAttributeUserName(principal, model);
        return "assign/mastermaintenance";
    }

    /**
     * ユーザー名設定<br>
     * ログイン情報をもとに、メニューに表示するユーザー名を設定する
     * @param principal
     * @param model
     */
    private void addAttributeUserName(Principal principal, Model model) {
		if (principal != null) {
	    	Authentication auth = (Authentication)principal;
	        User user = (User)auth.getPrincipal();
	        model.addAttribute("username", user.getUsername());
    	}
	}


}
