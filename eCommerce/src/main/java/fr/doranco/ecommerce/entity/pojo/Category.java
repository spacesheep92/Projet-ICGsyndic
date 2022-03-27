package fr.doranco.ecommerce.entity.pojo;

import javax.persistence.*;



@Entity 
@Table(name = "category")

public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = false, length = 45)
	private String name;
	@Column(name = "discount")
	private int discount;
	private boolean isDiscountCumulative;
	@Column(name = "name", length = 100)
	private String photo;
	@OneToMany
	@JoinColumn(name = "product_id")
	private Product product;
	
	public Category() {
		super();
	}

	public Category(int id, String name, int discount, boolean isDiscountCumulative, String photo, Product product) {
		super();
		this.id = id;
		this.name = name;
		this.discount = discount;
		this.isDiscountCumulative = isDiscountCumulative;
		this.photo = photo;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public boolean isDiscountCumulative() {
		return isDiscountCumulative;
	}

	public void setDiscountCumulative(boolean isDiscountCumulative) {
		this.isDiscountCumulative = isDiscountCumulative;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
