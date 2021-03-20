import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/UserDAO")
public class UserDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	public UserDAO() {

    }
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
  			          + "useSSL=false&user=john&password=pass1234");
            System.out.println(connect);
        }
    }
    
    //-------------------------------//
    //Users table here
	//-------------------------------//
    public void dropUserTable() throws SQLException{
    	String sql = "DROP TABLE IF EXISTS Users";
    	connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql);
    }
    
    public void createUserTable() throws SQLException{
    	String sql = "CREATE TABLE USERS (" + 
    			"email VARCHAR(100) NOT NULL," +
    			"password VARCHAR(20)," + 
    			"firstName VARCHAR(50)," +
    			"lastName VARCHAR(50)," + 
    			"gender CHAR(1)," + 
    			"age int," + 
    			"numFollowers int," +
    			"numFollowings int," +
    			"PRIMARY KEY(email))";
    	
    	connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql);
    }
    
    public void insertTenUsers() throws SQLException{
    	String sql1 ="INSERT INTO USERS" + 
    			"(email, password, firstName, lastName, gender, age, numFollowers, numFollowings)" + 
    			"VALUES (\"Diego@mail.com\", \"Diego1234\", \"Diego\", \"Hughes\", \"M\", 35, 12, 54)";
    	
    	String sql2 ="INSERT INTO USERS" + 
    			"(email, password, firstName, lastName, gender, age, numFollowers, numFollowings)" + 
    			"VALUES (\"Eve@mail.com\", \"Eve1234\", \"Eve\", \"Ellis\", \"F\", 20, 15, 40)";
    	
    	String sql3 ="INSERT INTO USERS" + 
    			"(email, password, firstName, lastName, gender, age, numFollowers, numFollowings)" + 
    			"VALUES (\"Raymond@mail.com\", \"Raymond1234\", \"Raymond\", \"Cline\", \"M\", 30, 160, 140)";
    	
    	String sql4 ="INSERT INTO USERS" + 
    			"(email, password, firstName, lastName, gender, age, numFollowers, numFollowings)" + 
    			"VALUES (\"Travis@mail.com\", \"Travis1234\", \"Travis\", \"Li\", \"M\", 22, 160, 140)";
    	
    	String sql5 ="INSERT INTO USERS" + 
    			"(email, password, firstName, lastName, gender, age, numFollowers, numFollowings)" + 
    			"VALUES (\"Bill@mail.com\", \"Bill1234\", \"Bill\", \"Walker\", \"M\", 30, 16, 14)";
    	
    	String sql6 ="INSERT INTO USERS" + 
    			"(email, password, firstName, lastName, gender, age, numFollowers, numFollowings)" + 
    			"VALUES (\"Zara@mail.com\", \"Zara1234\", \"Zara\", \"Glenn\", \"F\", 40, 130, 214)";
    	
    	String sql7 ="INSERT INTO USERS" + 
    			"(email, password, firstName, lastName, gender, age, numFollowers, numFollowings)" + 
    			"VALUES (\"Zaid@mail.com\", \"Zaid1234\", \"Zaid\", \"Warner\", \"M\", 22, 210, 214)";
    	
    	String sql8 ="INSERT INTO USERS" + 
    			"(email, password, firstName, lastName, gender, age, numFollowers, numFollowings)" + 
    			"VALUES (\"Ivy@mail.com\", \"Ivy1234\", \"Ivy\", \"Rivers\", \"F\", 19, 530, 218)";
    	
    	String sql9 ="INSERT INTO USERS" + 
    			"(email, password, firstName, lastName, gender, age, numFollowers, numFollowings)" + 
    			"VALUES (\"Jessie@mail.com\", \"Jessie1234\", \"Jessie\", \"Singh\", \"F\", 55, 30, 418)";
    	
    	String sql10 ="INSERT INTO USERS" + 
    			"(email, password, firstName, lastName, gender, age, numFollowers, numFollowings)" + 
    			"VALUES (\"Zavier@mail.com\", \"Zavier1234\", \"Zavier\", \"Stein\", \"M\", 39, 1530, 818)";
    	
    	String sql11 ="INSERT INTO USERS" + 
    			"(email, password, firstName, lastName, gender, age, numFollowers, numFollowings)" + 
    			"VALUES (\"root\", \"pass1234\", \"\", \"\", \"M\", 0, 0, 0)";
    	
    	
    	connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql1);
        statement.executeUpdate(sql2);
        statement.executeUpdate(sql3);
        statement.executeUpdate(sql4);
        statement.executeUpdate(sql5);
        statement.executeUpdate(sql6);
        statement.executeUpdate(sql7);
        statement.executeUpdate(sql8);
        statement.executeUpdate(sql9);
        statement.executeUpdate(sql10);
        statement.executeUpdate(sql11);
        statement.close();         
        disconnect(); 
    }
    
    //-------------------------------//
    //Users table here
	//-------------------------------//
    public void dropFollowTable() throws SQLException{
    	String sql = "DROP TABLE IF EXISTS FOLLOW";
    	connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql);
    }
    
    public void createFollowTable() throws SQLException{
    	String sql = "CREATE TABLE FOLLOW (" + 
    			"followingEmail VARCHAR(100) NOT NULL," +
    			"followerEmail VARCHAR(100) NOT NULL," + 
    			"PRIMARY KEY(followerEmail, followingEmail)," +
    			"FOREIGN KEY (followerEmail) REFERENCES USERS(email)," +
    			"FOREIGN KEY (followingEmail) REFERENCES USERS(email))";
    	
    	connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql);
    }
    
    public void insertTenFollow() throws SQLException{
    	String sql1 ="INSERT INTO FOLLOW" + 
    			"(followerEmail, followingEmail)" + 
    			"VALUES (\"Diego@mail.com\", \"Zavier@mail.com\")";
    	
    	String sql2 ="INSERT INTO FOLLOW" + 
    			"(followerEmail, followingEmail)" + 
    			"VALUES (\"Eve@mail.com\", \"Jessie@mail.com\")";
    	
    	String sql3 ="INSERT INTO FOLLOW" + 
    			"(followerEmail, followingEmail)" + 
    			"VALUES (\"Raymond@mail.com\", \"Ivy@mail.com\")";
    	
    	String sql4 ="INSERT INTO FOLLOW" + 
    			"(followerEmail, followingEmail)" + 
    			"VALUES (\"Travis@mail.com\", \"Zaid@mail.com\")";
    	
    	String sql5 ="INSERT INTO FOLLOW" + 
    			"(followerEmail, followingEmail)" + 
    			"VALUES (\"Bill@mail.com\", \"Zara@mail.com\")";
    	
    	String sql6 ="INSERT INTO FOLLOW" + 
    			"(followerEmail, followingEmail)" + 
    			"VALUES (\"Zara@mail.com\", \"Diego@mail.com\")";
    	
    	String sql7 ="INSERT INTO FOLLOW" + 
    			"(followerEmail, followingEmail)" + 
    			"VALUES (\"Jessie@mail.com\", \"Eve@mail.com\")";
    	
    	String sql8 ="INSERT INTO FOLLOW" + 
    			"(followerEmail, followingEmail)" + 
    			"VALUES (\"Zavier@mail.com\", \"Raymond@mail.com\")";
    	
    	String sql9 ="INSERT INTO FOLLOW" + 
    			"(followerEmail, followingEmail)" + 
    			"VALUES (\"Zaid@mail.com\", \"Bill@mail.com\")";
    	
    	String sql10 ="INSERT INTO FOLLOW" + 
    			"(followerEmail, followingEmail)" + 
    			"VALUES (\"Bill@mail.com\", \"Diego@mail.com\")";
    	
    	
    	
    	connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql1);
        statement.executeUpdate(sql2);
        statement.executeUpdate(sql3);
        statement.executeUpdate(sql4);
        statement.executeUpdate(sql5);
        statement.executeUpdate(sql6);
        statement.executeUpdate(sql7);
        statement.executeUpdate(sql8);
        statement.executeUpdate(sql9);
        statement.executeUpdate(sql10);
        statement.close();         
        disconnect(); 
    }
    
    public boolean registerUser(User user) throws SQLException {
    	connect_func();         
		String sql = "insert into users (email, password, firstName, lastName, gender, age) values (?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, user.email);
		preparedStatement.setString(2, user.password);
		preparedStatement.setString(3, user.firstName);
		preparedStatement.setString(4, user.lastName);
		preparedStatement.setString(5, user.gender);
		preparedStatement.setInt(6, user.age);
//		preparedStatement.executeUpdate();
		
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
//        disconnect();
        return rowInserted;
    } 
    
    public boolean loginUser(User user) throws SQLException{
    	connect_func();
    	boolean validUser = true;
    	
    	String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
    	
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, user.email);
        preparedStatement.setString(2, user.password);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        if(!resultSet.next()) {
        	validUser = false;
        }
        
        preparedStatement.close(); 
        
        return validUser;
    }
    
    public boolean checkEmail(String  email) throws SQLException{
    	connect_func();
    	
    	boolean found = false;
    	
    	String sql = "SELECT email FROM users";
    	
    	statement =  (Statement) connect.createStatement();
    	
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	while(resultSet.next()) {
    		String dbEmail = resultSet.getString("email");
    		if(dbEmail.contentEquals(email)) {
    			found = true;
    			//System.out.println("I am here");
    			return found;
    		}
    	}
    	return found;
    	
    }
    
    public User getUser(String email) throws SQLException{
    	User user = null;
    	
    	String sql = "SELECT * FROM USERS WHERE email = ?";
    	
    	connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String gender = resultSet.getString("gender");
            int age = resultSet.getInt("age");
            int numFollowers = resultSet.getInt("numFollowers");
            int numFollowings = resultSet.getInt("numFollowings");
            
            user = new User(email, firstName, lastName, gender, age, numFollowers, numFollowings);
        }
         
        resultSet.close();
    	
    	return user;
    }
    
    
    //Everything below from Ex4
  
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
}
