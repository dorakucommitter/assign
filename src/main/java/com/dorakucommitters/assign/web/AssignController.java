package com.dorakucommitters.assign.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dorakucommitters.assign.domain.EngagedInJoinOthers;
import com.dorakucommitters.assign.domain.Field;
import com.dorakucommitters.assign.domain.ProjectJoinOthers;
import com.dorakucommitters.assign.form.SearchSkillForm;
import com.dorakucommitters.assign.service.FieldService;
import com.dorakucommitters.assign.service.HoldingQualificationService;
import com.dorakucommitters.assign.service.HotEntryService;
import com.dorakucommitters.assign.service.QualificationService;


@Controller
@RequestMapping("/")
public class AssignController<T> {

    @Autowired
    FieldService fieldService;
    @Autowired
    QualificationService qualificationService;
    @Autowired
    HoldingQualificationService holdingQualificationService;
    @Autowired
    HotEntryService hotEntryService;

    @RequestMapping(method = RequestMethod.GET)
    String hotentry(Principal principal, Model model) {
    	addAttributeUserName(principal, model);
    	List<ProjectJoinOthers>projects = hotEntryService.createProjectJoinOthersList();
    	model.addAttribute("projects", projects);
    	List<EngagedInJoinOthers>engagedinlist = hotEntryService.createEngagedInJoinOthersList();
    	model.addAttribute("engagedinlist", engagedinlist);
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
    	List<Field>fields = fieldService.findAll();
    	model.addAttribute("fields", fields);
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


    @RequestMapping(value="assign/skilllist/{value}",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String changePulldown(@PathVariable("value")String value) {

        return qualificationService.createQualificationJsonByFieldId(value);
    }

    @RequestMapping(value="assign/skilltable",method=RequestMethod.POST,produces="text/plain;charset=UTF-8",consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String clickButtonSkillSearch(@RequestBody SearchSkillForm dto) {

    	return holdingQualificationService.createSkillList(dto);
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
