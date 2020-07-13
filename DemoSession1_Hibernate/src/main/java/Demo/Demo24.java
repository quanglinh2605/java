package Demo;

import Models.CategoryModel;
import entities.Category;

public class Demo24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CategoryModel categoryModel = new CategoryModel();
		Category category = new Category();
		category.setName("ABC");
		category = categoryModel.create(category);
		if (category == null) {
			System.out.println("Failed");
		} else {
			System.out.println("New ID: " + category.getId());
		}
	}
}
