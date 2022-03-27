package fr.doranco.ecommerce.entity.pojo;

import javax.persistence.*;



@Entity 
@Table(name = "address")

public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int id;
	@Column(name = "number", nullable = false, length = 10)
	private String number;
	@Column(name = "street", nullable = false, length = 10)
	private String street;
	@Column(name = "city", nullable = false, length = 45)
	private String city;
	@Column(name = "postCode", nullable = false, length = 10)
	private String postCode;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private int user_id;

	public Address(int id, String number, String street, String city, String postCode, int user_id) {
		super();
		this.id = id;
		this.number = number;
		this.street = street;
		this.city = city;
		this.postCode = postCode;
		this.user_id = user_id;
	}

	public Address() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", number=" + number + ", street=" + street + ", city=" + city + ", postCode="
				+ postCode + ", user_id=" + user_id + "]";
	}
	
	
	
}
