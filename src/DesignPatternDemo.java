import com.niit.pattern.dao.ProductDAO;
import com.niit.pattern.daoimpl.ProductDAOImpl;
import com.niit.pattern.entity.Product;

public class DesignPatternDemo {
private static ProductDAO productDAO = ProductDAOImpl.getProductDAO();
	public static void main(String[] args) {
		//displaying all the products
		
		displayAllProducts();
		
		//Adding product
		System.out.println("After Adding");
		Product product = new Product(6,"LG 3", "LG", "Mobile", "This is a Mobile", 25000, 12);
		productDAO.add(product);
		displayAllProducts();
		
		System.out.println("After Updating");
		//fetch the product by its id
		product = productDAO.get(3);
		
		//update the product name
		product.setName("G6");
		
		productDAO.update(product);
		displayAllProducts();
		
		//Deleting product
		System.out.println("After Deleting");
		product = productDAO.get(5);
		productDAO.delete(product);
		displayAllProducts();
		
		//find by Category
		System.out.println("Category");
		diplayProductsByCategory("Phone");
	}

	
	private static void diplayProductsByCategory(String category) {
		for(Product product : productDAO.getByCategory(category)){
			System.out.println(product);
		
	}


	}

	private static void displayAllProducts() {
		for (Product product : productDAO.list()) {
			System.out.println(product);
		}
	}

}
