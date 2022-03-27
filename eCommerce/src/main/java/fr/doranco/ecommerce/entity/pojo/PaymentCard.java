package fr.doranco.ecommerce.entity.pojo;

import javax.persistence.*;


@Entity 
@Table(name= "payment_card")
public class PaymentCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentcard_id")
	private int id;
	private String ownerFirstName;
	private String ownerLastName; 
	private byte[]  encrypt;
	@OneToOne
	@JoinColumn(name = "user_id")
	private int user_id;
	
	public PaymentCard() {
		super();
	}

	public PaymentCard(int id, String ownerFirstName, String ownerLastName, byte[] encrypt, int user_id) {
		super();
		this.id = id;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.encrypt = encrypt;
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public byte[] getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(byte[] encrypt) {
		this.encrypt = encrypt;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
}

