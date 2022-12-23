package com.quiz.user;

import com.quiz.connection.CreateConnection;
import com.quiz.result.Result;

import java.sql.*;
import java.util.*;

public class SearchUser {
	CreateConnection cc=new CreateConnection();
	Connection con=cc.getConnect();
	PreparedStatement ps=null;
	String query=null;
	ResultSet rs=null;
	String category;
	List<User> l1=new ArrayList<User>();
	List<Result> l2= new ArrayList<Result>();
	public void getAllUser()
	{
		try
		{
		l1.clear();
		l2.clear();
		query="select * from user,result,quizcategory where user.userid=result.userid and result.catid=quizcategory.catid order by marks desc";
		ps=con.prepareStatement(query);
		rs=ps.executeQuery();
		System.out.println("****** USERS LIST *****\n");
		while(rs.next())
		{
			System.out.println("UserId : "+rs.getInt(1));
			System.out.println("Username : "+rs.getString(2));
			System.out.println("Email : "+rs.getString(3));
			System.out.println("City : " +rs.getString(5));
			System.out.println("Mobile : "+rs.getLong(6));
			System.out.println("Marks : "+rs.getInt(10));
			System.out.println("Grade : "+rs.getString(11));
			System.out.println("Date : "+rs.getDate(12));	
			System.out.println("Quiz Name : "+rs.getString(14));
			System.out.println();
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	}
	
	public void getUserById(int userId)
	{
		try
		{
		l1.clear();
		l2.clear();
		query="select * from user,result,quizcategory where user.userid=result.userid and result.catid=quizcategory.catid and user.userid=?";
		ps=con.prepareStatement(query);
		ps.setInt(1,userId);
		rs=ps.executeQuery();
		System.out.println("****** USER DETAILS *****\n");
		while(rs.next())
		{
			System.out.println("UserId : "+rs.getInt(1));
			System.out.println("Username : "+rs.getString(2));
			System.out.println("Email : "+rs.getString(3));
			System.out.println("City : " +rs.getString(5));
			System.out.println("Mobile : "+rs.getLong(6));
			System.out.println("Marks : "+rs.getInt(10));
			System.out.println("Grade : "+rs.getString(11));
			System.out.println("Date : "+rs.getDate(12));	
			System.out.println("Quiz Name : "+rs.getString(14));	
			System.out.println();
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
	
	public void getUserByEmail(String email)
	{
		try
		{
		l1.clear();
		l2.clear();
		query="select * from user where email=?";
		ps=con.prepareStatement(query);
		ps.setString(1,email);
		rs=ps.executeQuery();
		System.out.println("****** USER DETAILS *****\n");
		while(rs.next())
		{
			System.out.println("UserId : "+rs.getInt(1));
			System.out.println("Username : "+rs.getString(2));
			System.out.println("Email : "+rs.getString(3));
			System.out.println("City : " +rs.getString(5));
			System.out.println("Mobile : "+rs.getLong(6));
			
			System.out.println();
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}
