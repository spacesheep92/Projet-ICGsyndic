package fr.doranco.ecommerce.entity.pojo;

import java.util.List;

import javax.persistence.*;



@Entity 
@Table(name = "product")

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;
	private String name;
	private String description;
	private float price;
	private int discount;
	private int Stock;
	private boolean isVendable;
	private String[] photos;
	private String[] videos;
	@OneToMany
	@JoinColumn(name = "comment_id")
	private List<Comment> comments;
	
	public Product() {
		super();
	}

	public Product(int id, String name, String description, float price, int discount, int stock, boolean isVendable,
			String[] photos, String[] videos, List<Comment> comments) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		Stock = stock;
		this.isVendable = isVendable;
		this.photos = photos;
		this.videos = videos;
		this.comments = comments;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public boolean isVendable() {
		return isVendable;
	}

	public void setVendable(boolean isVendable) {
		this.isVendable = isVendable;
	}

	public String[] getPhotos() {
		return photos;
	}

	public void setPhotos(String[] photos) {
		this.photos = photos;
	}

	public String[] getVideos() {
		return videos;
	}

	public void setVideos(String[] videos) {
		this.videos = videos;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
