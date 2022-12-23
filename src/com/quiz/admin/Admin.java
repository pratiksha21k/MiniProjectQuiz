package com.quiz.admin;

public class Admin {

	private String username;
	private String password;

	public String toString() {
		return "Admin[username= " + username + " password= " + password + "]";
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
/*
 * CreateConnection cc = new CreateConnection(); Connection con =
 * cc.getConnect();
 * 
 * public void createAdmin() { try { DatabaseMetaData db = con.getMetaData();
 * ResultSet table = db.getTables(null, null, "Admin", new String[] { "TABLE"
 * }); if (table.next()) { System.out.println("Table already exists"); } else {
 * String query =
 * "create table Admin (adminid int not null primary key auto_increment, username varchar(255),password varchar(255))"
 * ; Statement s = con.createStatement(); s.execute(query);
 * System.out.println("Table created successfully"); } } catch (Exception e) {
 * System.out.println(e); } }
 * 
 * public void insertAdmin(String name,String password) { try { String query =
 * "insert into Admin(username,password) values(?,?)"; PreparedStatement ps =
 * con.prepareStatement(query); ps.setString(1,name); ps.setString(2,password);
 * if(ps.execute()==false) System.out.println("Record inserted successfully"); }
 * catch(Exception e) { System.out.println(e); } }
 * 
 * public void selectAdmin() { try { String query = "Select * from Admin";
 * PreparedStatement ps= con.prepareStatement(query); ResultSet rs=
 * ps.executeQuery(); while(rs.next()) {
 * System.out.println("Username : "+rs.getString(2));
 * System.out.println("Password : "+rs.getString(3)); } } catch(Exception e) {
 * System.out.println(e); } }
 * 
 * public void deleteAdmin(int id) { try { String query =
 * "delete * from Admin where adminid=?"; PreparedStatement
 * ps=con.prepareStatement(query); ps.setInt(1,id); if(ps.execute()==false)
 * System.out.println("Record deleted successfully"); } catch(Exception e) {
 * System.out.println(e); } }
 * 
 * public void updateAdmin(String name,String password)
 * 
 * { try { String query ="update Admin set password=? where username=?";
 * PreparedStatement ps = con.prepareStatement(query); ps.setString(1,
 * password); ps.setString(2,name); if(ps.execute()==false)
 * System.out.println("Record updated successfully"); } catch(Exception e) {
 * System.out.println(e); } }
 */