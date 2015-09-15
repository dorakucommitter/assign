package com.dorakucommitters.assign.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Required;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private Integer employee_id;
	@Required
    public Integer getEmployee_id() {
		return employee_id;
	}
	@Required
	public String getEmployee_code() {
		return employee_code;
	}
	@Required
	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}
	@Required
	public String getName() {
		return name;
	}
	@Required
	public void setName(String name) {
		this.name = name;
	}
	@Required
	public String getNickname() {
		return nickname;
	}
	@Required
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Required
	public Date getBirthday() {
		return birthday;
	}
	@Required
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Required
	public String getGender() {
		return gender;
	}
	@Required
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Required
	public String getAddress() {
		return address;
	}
	@Required
	public void setAddress(String address) {
		this.address = address;
	}
	@Required
	public Date getJoin_date() {
		return join_date;
	}
	@Required
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	@Required
	public Date getLeave_date() {
		return leave_date;
	}
	@Required
	public void setLeave_date(Date leave_date) {
		this.leave_date = leave_date;
	}
	@Required
	public String getUser_id() {
		return user_id;
	}
	@Required
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Required
	public String getPassword() {
		return password;
	}
	@Required
	public void setPassword(String password) {
		this.password = password;
	}
	private String employee_code;
    private String name;
    private String nickname;
    private Date birthday;
    private String gender;
    private String address;
    private Date join_date;
    private Date leave_date;
    private String user_id;
    private String password;
    @Override
    public String toString()
    {
        return "Employee: employee_id=" + this.employee_id
                + " employee_code=" + this.employee_code
                + " name=" + this.name
                + " nickname=" + this.nickname
                + " birthday=" + this.birthday
                + " gender=" + this.gender
                + " address=" + this.address
                + " join_date=" + this.join_date
                + " leave_date=" + this.leave_date
                + " user_id=" + this.user_id
                + " password=" + this.password;
    }
	@Required
	public void setEmployee_id(Integer employee_id) {
		// TODO 自動生成されたメソッド・スタブ
		this.employee_id = employee_id;

	}

}
