package co.edureka.pms;

import java.util.List;
import java.util.Scanner;

import co.edureka.pms.config.ProductManagementFactory;
import co.edureka.pms.dao.ProductDao;
import co.edureka.pms.entiy.Product;

public class MainPms {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ProductDao dao = ProductManagementFactory.getProductManagement();
		while (true) {
			System.out.println("1. Add Product");
			System.out.println("2. Search Product");
			System.out.println("3. Delete Product");
			System.out.println("4. Update Product");
			System.out.println("5. All Products");
			System.out.println("6. Exit");

			System.out.print("Enter an option: ");
			int opt = sc.nextInt();
			System.out.println("----------------------------------------------");

			switch (opt) {
			case 1:
				System.out.print("Enter Product Id: ");
				int pid = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Product Name: ");
				String name = sc.next();
				System.out.print("Enter Product Price: ");
				float price = sc.nextFloat();

				Product p = new Product(pid, name, price);
				dao.saveProduct(p);

				break;
			case 2:
				System.out.print("Enter Product Id: ");
				int id = sc.nextInt();
				Product product = dao.searchProduct(id);
				if (product == null)
					System.out.println("$$$ NO PRODUCT WITH ID: " + id + "$$$");
				else
					System.out.println(product);

				break;
			case 3:
				System.out.print("Enter product id to delete: ");
				pid = sc.nextInt();
				dao.deleteProduct(pid);

				break;
			case 4:
				System.out.println("---Update Product----");
				break;
			case 5:
				List<Product> products = dao.getProducts();
				for (Product prod : products) {
					System.out.println(prod);
					Thread.sleep(1000);
				}
				break;
			case 6:
				System.out.println("$$$$ BYE BYE...$$$$");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("### INVALID OPTION...TRY AGAIN ###");
			}
			System.out.println("========================================================");
		}

	}

}
