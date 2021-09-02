//Entity Class -DTO(POJO- Plain Old Java Object)
package co.edureka.pms.entiy;

public class Product {
	private Integer productId;
	private String productName;
	private Float productPrice;

	public Product() {
	}

	public Product(Integer productId, String productName, Float productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [" + productId + " | " + productName + " | " + productPrice + "]";
	}

}
