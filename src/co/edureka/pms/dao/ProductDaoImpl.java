package co.edureka.pms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edureka.pms.config.ConnectionFactory;
import co.edureka.pms.entiy.Product;

public class ProductDaoImpl implements ProductDao {
	private static Statement st = null;

	public ProductDaoImpl() throws Exception {
		Connection con = ConnectionFactory.getConnection();
		st = con.createStatement();
	}

	@Override
	public void saveProduct(Product product) throws Exception {
		String sql = "insert into product values(" + product.getProductId() + ", '" + product.getProductName() + "',"
				+ product.getProductPrice() + ")";
		int n = st.executeUpdate(sql);
		System.out.println("#### Product Saved ####");

	}

	@Override
	public void updateProduct(Product product) throws Exception {
		String sql = "update product set productName='" + product.getProductName() + "',productPrice ="
				+ product.getProductPrice() + "where productId =" + product.getProductId();
		int n = st.executeUpdate(sql);
		if (n > 0)
			System.out.println("#### Product Updated ####");

	}

	@Override
	public void deleteProduct(int pid) throws Exception {
		String sql = "delete from product where productId = " + pid;
		int n = st.executeUpdate(sql);
		if (n > 0)
			System.out.println("#### Product Deleted ####");
		else
			System.out.println("#### No Product found for deletion ####");

	}

	@Override
	public Product searchProduct(int pid) throws Exception {
		Product product = null;
		String sql = "select productName, productPrice from product where productId=" + pid;
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			String pname = rs.getString(1);
			float price = rs.getFloat(2);
			product = new Product(pid, pname, price);
		}
		return product;
	}

	@Override
	public List<Product> getProducts() throws Exception {
		List<Product> products = new ArrayList<>();

		String sql = "select * from product";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Product product = new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			// Add Product to list
			products.add(product);
		}

		return products;
	}

}
