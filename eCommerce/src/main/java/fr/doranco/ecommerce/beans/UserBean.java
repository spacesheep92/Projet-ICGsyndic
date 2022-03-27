package fr.doranco.ecommerce.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.dto.UserDto;
import fr.doranco.ecommerce.metier.IUserMetier;
import fr.doranco.ecommerce.metier.UserMetier;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

	private String id;

	@ManagedProperty(value = "")
	private String firstName;

	@ManagedProperty(value = "")
	private String lastName;

	@ManagedProperty(value = "")
	private String email;
	
	private String password;
	private String passwordConf;
	
	@ManagedProperty(value = "")
	private String birthday;
	
	@ManagedProperty(value = "")
	private String phone;
	
	@ManagedProperty(value = "")
	private String address;

	private static String messageSuccess;
	private static String messageError;

	private final IUserMetier userMetier = new UserMetier();
	
	static {
		messageSuccess = "";
		messageError = "";
	}
	
	public UserBean() {
	}

	public List<UserDto> getUsers() {
		
		try {
			return userMetier.getUsers();
			
		} catch (Exception e) {
			System.out.println(e);
			UserBean.messageError = "Erreur lors de la récupération de la liste des utilisateurs !\n " + e.getMessage();
			return new ArrayList<UserDto>();
		}
	}
	
	public String ajouter() {
		
		UserBean.messageSuccess = "";
		UserBean.messageError = "";
		
		if (!password.equals(passwordConf)) {
			UserBean.messageError = "Les deux mots de passe ne correspondent pas !\nVeuillez réessayer";
			return "";
		}
		
		UserDto userDto = new UserDto();
		userDto.setlastName(lastName);
		userDto.setfirstName(firstName);
		userDto.setPhone(phone);
		userDto.setEmail(email);
		userDto.setPassword(password);
		userDto.setbirthday(birthday);
		userDto.setAddress(address);
		
		try {
			UserDto addedUserDto = userMetier.addUserDto(userDto); 
			this.id = addedUserDto.getId();
			UserBean.messageSuccess = "Utilisateur crée avec succès.";
			
		} catch (Exception e) {
			System.out.println(e);
			UserBean.messageError = "Erreur lors de la création de l'utilisateur !\n " + e.getMessage();
		}
		return "";
	}

	public void initialiser() {
		
		this.id = "";
		this.lastName = "";
		this.firstName = "";
		this.phone = "";
		this.email = "";
		this.password = "";
		this.passwordConf = "";
		this.birthday = "";
		this.address = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String motDePasse) {
		this.password = motDePasse;
	}

	public String getpasswordConf() {
		return passwordConf;
	}

	public void setpasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}

	public String getbirthday() {
		return birthday;
	}

	public void setbirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMessageSuccess() {
		return UserBean.messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		UserBean.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return UserBean.messageError;
	}

	public void setMessageError(String messageError) {
		UserBean.messageError = messageError;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
