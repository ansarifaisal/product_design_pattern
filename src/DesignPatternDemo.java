import com.niit.pattern.dao.ProductDAO;
import com.niit.pattern.daoimpl.ProductDAOImpl;
import com.niit.pattern.entity.Product;

public class DesignPatternDemo {

	public static void main(String[] args) {
		//displaying all the products
		ProductDAO productDAO = ProductDAOImpl.getProductDAO();
		displayAllProducts(productDAO);
		
		//Adding product
		System.out.println("After Adding");
		Product product = new Product(6,"LG 3", "LG", "Mobile", "This is a Mobile", 25000, 12);
		productDAO.add(product);
		displayAllProducts(productDAO);
		
		System.out.println("After Updating");
		//fetch the product by its id
		product = productDAO.get(3);
		
		//update the product name
		product.setName("G6");
		
		productDAO.update(product);
		displayAllProducts(productDAO);
		
		//Deleting product
		System.out.println("After Deleting");
		product = productDAO.get(5);
		productDAO.delete(product);
		displayAllProducts(productDAO);
		
		//find by Category
		System.out.println("Category");
		product = productDAO.getCat("Mobile");
		displayProductByCategory(productDAO);
	}

	private static void displayProductByCategory(ProductDAO productDAO) {
		for (Product product : productDAO.catList()) {
			System.out.println(product);
		}
		
	}

	private static void displayAllProducts(ProductDAO productDAO) {
		for (Product product : productDAO.list()) {
			System.out.println(product);
		}
	}

}
