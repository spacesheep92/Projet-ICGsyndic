package fr.doranco.ecommerce.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "loginBean")
public class LoginBean {

	private String email;
	private String password;
	
	private static String messageSuccess;
	private static String messageError;

	static {
		messageSuccess = "";
		messageError = "";
	}
	
	public LoginBean() {
	}

	public String seConnecter() {
		
		return "";
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMessageSuccess() {
		return LoginBean.messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		LoginBean.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return LoginBean.messageError;
	}

	public void setMessageError(String messageError) {
		LoginBean.messageError = messageError;
	}
}
