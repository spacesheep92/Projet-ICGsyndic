package fr.doranco.ecommerce.entity.pojo;

import java.util.List;
import javax.persistence.*;

@Entity 
@Table(name = "order")

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	@Column(name = "number", nullable = false)
	private int number;
	@Column(name = "dateCreate", nullable = false, length = 8)
	private String dateCreate;
	@Column(name = "dateDelivery", nullable = false, length = 8)
	private String dateDelivery;
	@Column(name = "totalDiscount", nullable = false)
	private int totalDiscount;
	@Column(name = "chargeDelivery", nullable = false)
	private int chargeDelivery;
	@Column(name = "totalPrice", nullable = false)
	private int totalPrice;
	@OneToOne
	@JoinColumn(name = "address_id" )
	private Address addressBilling;
	@OneToOne
	@JoinColumn(name = "address_id" )
	private Address  addressDelivery;
	@OneToOne
	@JoinColumn(name = "paymentcard_id")
	private PaymentCard  defaultPaymentCard;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToMany
	@JoinColumn(name = "orderLine_id")
	private List<OrderLine> orderLine;
	
	public Order() {
		super();
	}

	public Order(int id, int number, String dateCreate, String dateDelivery, int totalDiscount, int chargeDelivery,
			int totalPrice, Address addressBilling, Address addressDelivery, PaymentCard defaultPaymentCard, User user,
			List<OrderLine> orderLine) {
		super();
		this.id = id;
		this.number = number;
		this.dateCreate = dateCreate;
		this.dateDelivery = dateDelivery;
		this.totalDiscount = totalDiscount;
		this.chargeDelivery = chargeDelivery;
		this.totalPrice = totalPrice;
		this.addressBilling = addressBilling;
		this.addressDelivery = addressDelivery;
		this.defaultPaymentCard = defaultPaymentCard;
		this.user = user;
		this.orderLine = orderLine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(String dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public int getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(int totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public int getChargeDelivery() {
		return chargeDelivery;
	}

	public void setChargeDelivery(int chargeDelivery) {
		this.chargeDelivery = chargeDelivery;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Address getAddressBilling() {
		return addressBilling;
	}

	public void setAddressBilling(Address addressBilling) {
		this.addressBilling = addressBilling;
	}

	public Address getAddressDelivery() {
		return addressDelivery;
	}

	public void setAddressDelivery(Address addressDelivery) {
		this.addressDelivery = addressDelivery;
	}

	public PaymentCard getDefaultPaymentCard() {
		return defaultPaymentCard;
	}

	public void setDefaultPaymentCard(PaymentCard defaultPaymentCard) {
		this.defaultPaymentCard = defaultPaymentCard;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderLine> getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}

	
	
	
}
