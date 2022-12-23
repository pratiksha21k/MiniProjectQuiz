package com.quiz.category;

import java.sql.*;
import java.util.Scanner;

import com.quiz.admin.AdminDashboard;
import com.quiz.connection.CreateConnection;

public class CreateCategory {
	CreateConnection cc = new CreateConnection();
	Connection con = cc.getConnect();
	Category cat = new Category();
	Scanner sc=new Scanner(System.in);

	// create table if it is not present in database.
	public void createCategory() {
		try {
			DatabaseMetaData db = con.getMetaData();
			ResultSet table = db.getTables(null, null, "Quizcategory", new String[] { "TABLE" });
			if (table.next()) {
				System.out.println();

			} else {
				String query = "create table Quizcategory( catid int not null primary key auto_increment,category varchar(255))";
				Statement s = con.createStatement();
				if (s.execute(query) == false)
					System.out.println("Table created successfully");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// insert records into table
	public void insertCategory(String category) {
		try {
			createCategory();
			String query = "insert into Quizcategory(category) values(?)";
			PreparedStatement ps = con.prepareStatement(query);
			cat.setCategory(category);
			ps.setString(1, cat.getCategory());
			if (ps.execute() == false)
			{
				System.out.println("category inserted successfully");
				System.out.println("Do you want to add one more Quiz [yes/no] :");
				String choice=sc.nextLine();
				if(choice.equalsIgnoreCase("yes"))
				{
					insertCategory(category);
				}
				else
				{
					AdminDashboard.selectOption();
				}	
			}
			else
			{
				System.out.println("Insertion fail");
				AdminDashboard.selectOption();
			}
				
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// delete specific category
	public void deleteCategory(String category) {
		try {
			String query = "delete from Quizcategory where category=?";
			PreparedStatement ps = con.prepareStatement(query);
			cat.setCategory(category);
			ps.setString(1, cat.getCategory());
			if (ps.execute() == false)
			{
				System.out.println("delete record successfully");
				AdminDashboard.selectOption();
			}
			else
			{
				System.out.println("Deletion fail");
				AdminDashboard.selectOption();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// update category wrt id.
	public void updateCategory(String category, int id) {
		try {
			String query = "update Quizcategory set category=? where catid=?";
			PreparedStatement ps = con.prepareStatement(query);
			cat.setCategory(category);
			cat.setCatid(id);
			ps.setString(1, cat.getCategory());
			ps.setInt(2, cat.getCatid());
			if (ps.execute() == false)
			{
				System.out.println("update record successfully");
				AdminDashboard.selectOption();
			}
			else
			{
				System.out.println("Updation fail");
				AdminDashboard.selectOption();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Select categories from database
	public void selectCategory() {
		try {
			String query = "select * from Quizcategory ";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
		    while (rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
