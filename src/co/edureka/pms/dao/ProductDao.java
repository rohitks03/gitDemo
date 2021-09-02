package co.edureka.pms.dao;

import java.util.List;

import co.edureka.pms.entiy.Product;

public interface ProductDao {
	public void saveProduct(Product product) throws Exception;
	public void updateProduct(Product product) throws Exception;
	public void deleteProduct(int pid) throws Exception;
	public Product searchProduct(int pid) throws Exception;
	public List<Product> getProducts() throws Exception;
	
		
	

}
