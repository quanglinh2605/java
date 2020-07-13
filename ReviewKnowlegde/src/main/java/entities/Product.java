package entities;

public class Product {
	private String id;
	private String name;
	private double price;
	private String category;
	private String photo;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Product() {
		super();
	}

	public Product(String id, String name,String photo, double price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
