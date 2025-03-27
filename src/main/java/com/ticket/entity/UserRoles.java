package com.ticket.entity;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserRoles {
	  @Schema(description = "Name of the user")
	 private String name;
	  @Schema(description = "UserName of the user")
	 private String userName;
	  @Schema(description = "Email of the user")
	 private String email;
	  @Schema(description = "Department of the user")
	 private String department;
	  @Schema(description = "Phone of the user")
	 private Long phone;
	  @Schema(description = "Password of the user")
	 private String password;
	  @Schema(description = "Role of the user")
	 private String role;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
