package com.techpalle.model;

public class Admin {
	private int ano;
	private String adminUsername;
	private String adminPassword;
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	public Admin() {
		super();
	}
	
	public Admin(int ano, String adminUsername, String adminPassword) {
		super();
		this.ano = ano;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}
	
	public Admin(String adminUsername, String adminPassword) {
		super();
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}
	
}
