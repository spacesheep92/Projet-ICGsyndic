package fr.doranco.ecommerce.entity.pojo;

import javax.persistence.*;

@Entity 
@Table(name = "cart")

public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name = "product_id")
	private int product_id;
	@Column(name = "amount")
	private int amount;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Cart() {
		super();
	}

	public Cart(int id, int product_id, int amount, User user) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.amount = amount;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", product_id=" + product_id + ", amount=" + amount + ", user=" + user + "]";
	}

	
	
}
