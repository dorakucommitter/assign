package com.dorakucommitters.assign.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EmployeeForm
{
    @NotNull
    @Size(min = 6, max = 6)
    private String employeeCode;

    @NotNull
    @Size(max = 40)
    private String name;

    @NotNull
    @Size(min = 4, max = 40)
    private String userId;

    @NotNull
    @Size(min = 4, max = 40)
    private String password;


    public String getEmployeeCode()
    {
        return this.employeeCode;
    }

    public String getName()
    {
        return this.name;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public String getPassword()
    {
        return this.password;
    }


    public void setEmployeeCode(String code)
    {
        this.employeeCode = code;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
