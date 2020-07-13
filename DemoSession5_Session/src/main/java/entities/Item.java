package entities;

public class Item {
	private Product product;
	private int Quantity;

	public Item() {
		super();
	}

	public Item(Product product, int quantity) {
		super();
		this.product = product;
		Quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

}
