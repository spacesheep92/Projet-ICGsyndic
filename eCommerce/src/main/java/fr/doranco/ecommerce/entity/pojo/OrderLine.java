package fr.doranco.ecommerce.entity.pojo;

import javax.persistence.*;

@Entity 
@Table(name = "order_line")


public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderLine_id")
	private int id;
	@Column(name = "amount", nullable = false)
	private int  amount;
	@Column(name = "unitPrice", nullable = false)
	private float unitPrice;
	@Column(name = "productDiscount", nullable = false)
	private int productDiscount;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	public OrderLine() {
		super();
	}

	public OrderLine(int id, int amount, float unitPrice, int productDiscount, Order order, Product product) {
		super();
		this.id = id;
		this.amount = amount;
		this.unitPrice = unitPrice;
		this.productDiscount = productDiscount;
		this.order = order;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
	
}
