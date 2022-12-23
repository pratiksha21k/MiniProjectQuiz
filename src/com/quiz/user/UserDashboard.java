package com.quiz.user;

import java.util.Scanner;

import com.quiz.main.Quiz;

public class UserDashboard {

	public static void selectOption() {
		String choice;
		int userId;
		UserOperation userop = new UserOperation();
		SearchUser search=new SearchUser();
		Scanner sc = new Scanner(System.in);
		System.out.println("***** USER DASHBOARD *****");
		System.out.println("1.Start Quiz");
		System.out.println("2.View Profile");
		System.out.println("3.Update Profile");
		System.out.println("4.Delete Profile");
		System.out.println("5.View Result");
		System.out.println("6.Logout");
		System.out.println("Choose which operation you want to perform [1/2/3/4/5/6] : ");
		int option = Integer.parseInt(sc.nextLine());
		switch (option) {
		case 1 :
			StartQuiz start=new StartQuiz();
			start.getQuiz();
			break;

		case 2 :
			System.out.println("Enter Your Email to view profile");
			String email=sc.nextLine();
			search.getUserByEmail(email);
			selectOption();
			break;

		case 3 :
			System.out.println("Do you want to continue with update [yes/no]");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("no")) {
				selectOption();
				break;
			} else
				userop.getUpdateUser();
			break;

		case 4 :
			System.out.println("Enter User Id to delete record");
			userId = Integer.parseInt(sc.nextLine());
			System.out.println("Are you sureyou want to delete record[yes/no]");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("no")) {
				selectOption();
				break;
			} else
				userop.deleteUser(userId);
			break;
			
		case 5 :
			System.out.println("Enter Your Userid to view result");
			userId=Integer.parseInt(sc.nextLine());
			search.getUserById(userId);
			selectOption();
			break;

		case 6 :
			Quiz.selectLogin();
			break;

		default:
			System.out.println("Invalid Input please enter correct option");
			selectOption();
		}
		sc.close();
	}
}
