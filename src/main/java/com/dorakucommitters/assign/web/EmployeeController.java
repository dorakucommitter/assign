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

import com.dorakucommitters.assign.domain.Employee;
import com.dorakucommitters.assign.form.EmployeeForm;
import com.dorakucommitters.assign.service.EmployeeService;
import com.dorakucommitters.assign.service.LoginEmployeeDetails;

@Controller
@RequestMapping("employee")
public class EmployeeController
{
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;


    @ModelAttribute
    EmployeeForm setUpForm()
    {
        return new EmployeeForm();
    }


    @RequestMapping(method = RequestMethod.GET)
    String list(Model model, @AuthenticationPrincipal LoginEmployeeDetails loginEmployee)
    {
        List<Employee> employees = this.employeeService.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("username", loginEmployee.getUsername());

        employees.forEach(e -> logger.info(e.toString()));
        return "employee/list";
    }

    @RequestMapping(value = "detail", method=RequestMethod.GET)
    String detail(@RequestParam Integer id, Model model, @AuthenticationPrincipal LoginEmployeeDetails loginEmployee)
    {
        Employee employee = this.employeeService.findOne(id);
        model.addAttribute("employee", employee);
        model.addAttribute("username", loginEmployee.getUsername());
        return "employee/detail";
    }


    @RequestMapping(value = "create", method = RequestMethod.GET)
    String createForm(Model model, @AuthenticationPrincipal LoginEmployeeDetails loginEmployee)
    {
        model.addAttribute("username", loginEmployee.getUsername());
        return "employee/create";
    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated EmployeeForm form, BindingResult result, Model model,
        @AuthenticationPrincipal LoginEmployeeDetails loginEmployee)
    {
        logger.info(form.getName());
        if (result.hasErrors()) {
            return this.createForm(model, loginEmployee);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(form, employee);
        this.employeeService.create(employee);
        return "redirect:/employee";
    }


    @RequestMapping(value = "edit", method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, EmployeeForm form, Model model, @AuthenticationPrincipal LoginEmployeeDetails loginEmployee)
    {
        Employee employee = this.employeeService.findOne(id);
        logger.info(employee.toString());
        BeanUtils.copyProperties(employee, form);

        model.addAttribute("username", loginEmployee.getUsername());
        return "employee/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(@RequestParam Integer id, @Validated EmployeeForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginEmployeeDetails loginEmployee)
    {
        if (result.hasErrors()) {
            logger.error(result.toString());
            return this.editForm(id, form, model, loginEmployee);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(form, employee);
        employee.setEmployeeId(id);
        this.employeeService.update(employee);
        return "redirect:/employee";
    }


    @RequestMapping(value = "delete", method = RequestMethod.GET)
        String delete(@RequestParam Integer id)
    {
        this.employeeService.delete(id);
        return "redirect:/employee";
    }
}
