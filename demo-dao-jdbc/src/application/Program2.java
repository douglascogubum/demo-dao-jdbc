package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("=== Test 1: department findById ===");
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department dp = departmentDao.findById(3);
		System.out.println(dp);
		
		System.out.println("=== Test 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("=== Test 3: department insert ===");
		Department newDp = new Department(null, "Shoes");
		departmentDao.insert(newDp);
		System.out.println("Inserted!" + newDp);
		
		System.out.println("=== Test 4: department update ===");
		Department updateDp = departmentDao.findById(1);
		updateDp.setName("Computer");
		departmentDao.update(updateDp);
		System.out.println("Update Completed!");
		
		System.out.println("=== Test 4: department update ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed!");
		
		sc.close();
	}
}