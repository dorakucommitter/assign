package com.dorakucommitters.assign.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dorakucommitters.assign.domain.Field;
import com.dorakucommitters.assign.form.FieldForm;
import com.dorakucommitters.assign.service.FieldService;
import com.dorakucommitters.assign.service.LoginEmployeeDetails;

@Controller
@RequestMapping("field")
public class FieldController
{
    private static final Logger logger = LoggerFactory.getLogger(FieldController.class);

    @Autowired
    FieldService fieldService;

    @ModelAttribute
    FieldForm setUpForm()
    {
        return new FieldForm();
    }

    /**
     * 専門分野一覧表示
     *
     * @param model テンプレートモジュール
     * @param loginEmployee  認証情報
     * @return String  テンプレートファイル名
     */
    @RequestMapping(method = RequestMethod.GET)
    String list(
        Model model,
        @AuthenticationPrincipal LoginEmployeeDetails loginEmployee
    ){
        List<Field> fields = this.fieldService.findAll();
        model.addAttribute("fields", fields);
        model.addAttribute("username", loginEmployee.getUsername());
        return "field/list";
    }

    /**
     * 専門分野の詳細表示
     *
     * @param id
     * @param model
     * @param loginEmployee
     * @return
     */
    @RequestMapping(value = "detail", method=RequestMethod.GET)
    String detail(
        @RequestParam Integer id,
        Model model,
        @AuthenticationPrincipal LoginEmployeeDetails loginEmployee
    ){
        Field field = this.fieldService.findOne(id);
        model.addAttribute("field", field);
        model.addAttribute("qualifications", field.getQualifications());
        model.addAttribute("username", loginEmployee.getUsername());
        return "field/detail";
    }

    /**
     * 専門分野の新規登録
     *
     * @param model
     * @param loginEmployee
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.GET)
    String createForm(
        Model model,
        @AuthenticationPrincipal LoginEmployeeDetails loginEmployee)
    {
        model.addAttribute("username", loginEmployee.getUsername());
        return "field/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(
        @Validated FieldForm form,
        BindingResult result,
        Model model,
        @AuthenticationPrincipal LoginEmployeeDetails loginEmployee)
    {
        if (result.hasErrors()) {
            return this.createForm(model, loginEmployee);
        }
        Field field = new Field();
        BeanUtils.copyProperties(form, field);
        this.fieldService.create(field);
        return "redirect:/field";
    }


    /**
     * 専門分野の編集
     *
     * @param id
     * @param form
     * @param model
     * @param loginEmployee
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    String editForm(
        @RequestParam Integer id,
        FieldForm form, Model model,
        @AuthenticationPrincipal LoginEmployeeDetails loginEmployee
    ){
        Field field = this.fieldService.findOne(id);
        BeanUtils.copyProperties(field, form);

        model.addAttribute("username", loginEmployee.getUsername());
        return "field/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(
        @RequestParam Integer id,
        @Validated FieldForm form,
        BindingResult result, Model model,
        @AuthenticationPrincipal LoginEmployeeDetails loginEmployee)
    {
        if (result.hasErrors()) {
            logger.error(result.toString());
            return this.editForm(id, form, model, loginEmployee);
        }
        Field field = new Field();
        BeanUtils.copyProperties(form, field);
        field.setFieldId(id);
        this.fieldService.update(field);
        return "redirect:/field";
    }


    /**
     * 専門分野の削除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    String delete(@RequestParam Integer id)
    {
        this.fieldService.delete(id);
        return "redirect:/field";
    }
}

