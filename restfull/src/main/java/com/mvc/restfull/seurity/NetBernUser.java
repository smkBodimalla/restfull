package com.mvc.restfull.seurity;

import java.io.Serializable;

public class NetBernUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String passWord;
	private int locked;
	private int disable;
	private Role role;

	

	public NetBernUser() {
		// TODO Auto-generated constructor stub
	}

	public NetBernUser(String userName, String passWord, int locked, int disable, Role role) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.locked = locked;
		this.disable = disable;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public int getDisable() {
		return disable;
	}

	public void setDisable(int disable) {
		this.disable = disable;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
