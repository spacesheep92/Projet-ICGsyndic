package fr.doranco.ecommerce.entity.pojo;

import javax.persistence.*;



@Entity 
@Table(name = "comment")

public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private int id;
	@Column(name = "text", nullable = false, length = 200)
	private String text;
	@Column(name = "note", nullable = false)
	private int note;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	public Comment() {
		super();
	}

	public Comment(int id, String text, int note, User user, Product product) {
		super();
		this.id = id;
		this.text = text;
		this.note = note;
		this.user = user;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
