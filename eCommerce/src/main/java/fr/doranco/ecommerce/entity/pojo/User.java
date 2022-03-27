package fr.doranco.ecommerce.entity.pojo;

import java.util.Arrays;
import java.util.List;


import javax.persistence.*;
import fr.doranco.ecommerce.enums.EnumProfile;


@Entity 
@Table(name = "user")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	@Column(name = "firstName", nullable = false, length = 45)
	private String firstName ;
	@Column(name = "lastName", nullable = false, length = 45)
	private String lastName;
	@Column(name = "birthday", nullable = false, length = 45)
	private String birthday;	
	
	@Enumerated(EnumType.STRING)
	private EnumProfile profile;
	
	private boolean  isActif;
	@Column(name = "password", nullable = false)
	private byte[] password;
	@Column(name = "email", nullable = false, length = 45, unique = true)
	private String email;
	@Column(name = "phone", nullable = false, length = 45, unique = true)
	private String phone;
	
	@OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<Address> address;
	
	@OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<Order> order;
	
	@OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<PaymentCard> paymentCard;
	
	@OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<Comment> comment;
	
	@OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.LAZY) 
    private List<Cart> cart;

	public User() {
		super();
	}

	public User(int id, String firstName, String lastName, String birthday, EnumProfile profile, boolean isActif,
			byte[] password, String email, String phone, List<Address> address, List<Order> order,
			List<PaymentCard> paymentCard, List<Comment> comment, List<Cart> cart) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.profile = profile;
		this.isActif = isActif;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.order = order;
		this.paymentCard = paymentCard;
		this.comment = comment;
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public EnumProfile getProfile() {
		return profile;
	}

	public void setProfile(EnumProfile profile) {
		this.profile = profile;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public List<PaymentCard> getPaymentCard() {
		return paymentCard;
	}

	public void setPaymentCard(List<PaymentCard> paymentCard) {
		this.paymentCard = paymentCard;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	
	public String idToString() {
		return "User [id=" + id + "]";
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
				+ ", profile=" + profile + ", isActif=" + isActif + ", password=" + Arrays.toString(password)
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", order=" + order
				+ ", paymentCard=" + paymentCard + ", comment=" + comment + ", cart=" + cart + "]";
	}

	
}
