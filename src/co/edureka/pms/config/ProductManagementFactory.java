package co.edureka.pms.config;

import co.edureka.pms.dao.ProductDao;
import co.edureka.pms.dao.ProductDaoImpl;

public class ProductManagementFactory {
	private static ProductDao productDao = null;
	public static ProductDao getProductManagement() throws Exception{
		if (productDao == null) {
			productDao = new ProductDaoImpl();
			
		}
		return productDao;
	}

}
