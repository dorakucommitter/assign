package com.dorakucommitters.assign.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee
{
    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_code", nullable = false)
	private String employeeCode;

    @Column
    private String name;

    @Column
    private String nickname;

    @Column
    private Date birthday;

    @Column
    private String gender;

    @Column
    private String address;

    @Column(name = "join_date", nullable = true)
    private Date joinDate;

    @Column(name = "leave_date", nullable = true)
    private Date leaveDate;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column
    private String roll;


    public Integer getEmployeeId()
    {
        return employeeId;
    }

    public String getEmployeeCode()
    {
        return employeeCode;
    }

    public String getName()
    {
        return name;
    }

    public String getNickname()
    {
        return nickname;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public String getGender()
    {
        return gender;
    }

    public String getAddress()
    {
        return address;
    }

    public Date getJoinDate()
    {
        return joinDate;
    }

    public Date getLeaveDate()
    {
        return leaveDate;
    }

    public String getUserId()
    {
        return userId;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRoll()
    {
        return roll;
    }



    public void setEmployeeId(Integer employeeId)
    {
        this.employeeId = employeeId;
    }

    public void setEmployeeCode(String employee_code)
    {
        this.employeeCode = employee_code;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setJoinDate(Date joinDate)
    {
        this.joinDate = joinDate;
    }

    public void setLeaveDate(Date leave_date)
    {
        this.leaveDate = leave_date;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setPassword(String password)
    {
        PasswordEncoder passwdEncoder = new BCryptPasswordEncoder();
        this.password = passwdEncoder.encode(password);
    }

    public void setRoll(String roll)
    {
        this.roll = roll;
    }


    @Override
    public String toString()
    {
        return "Employee: employee_id=" + this.employeeId
                + " employee_code=" + this.employeeCode
                + " name=" + this.name
                + " nickname=" + this.nickname
                + " birthday=" + this.birthday
                + " gender=" + this.gender
                + " address=" + this.address
                + " join_date=" + this.joinDate
                + " leave_date=" + this.leaveDate
                + " user_id=" + this.userId
                + " password=" + this.password
                + " roll=" + this.roll;
    }
}
