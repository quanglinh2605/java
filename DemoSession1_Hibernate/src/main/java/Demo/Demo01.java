package Demo;

import java.util.List;

import Models.CategoryModel;
import entities.Category;
import entities.Product;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CategoryModel CategoryModel = new CategoryModel();
		List<Category> categories = CategoryModel.findAll();
		System.out.println("categories: " + categories.size());
		for (Category category : categories) {
			System.out.println("id: " + category.getId());
			System.out.println("name: " + category.getName());
			System.out.println("Products: " + category.getProducts().size());
			if (category.getProducts().size() != 0) {
				for (Product pro : category.getProducts()) {
					System.out.println("\tid: " + pro.getId());
					System.out.println("\tname: " + pro.getName());
					System.out.println("\tprice: " + pro.getPrice());
					System.out.println("\tstatus: " + pro.isStatus());
					System.out.println("---------------------------");
				}
			}
			System.out.println("============================");
		}
	}

}
