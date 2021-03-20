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
@WebServlet("/ImagesDAO")
public class ImagesDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	public ImagesDAO() {

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
    //Images table here
    //-------------------------------//
    
    public void dropImagesTable() throws SQLException{
    	String sql = "DROP TABLE IF EXISTS IMAGES";
    	connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql);
    }
    
    public void createImagesTable() throws SQLException{
    	String sql = "CREATE TABLE IMAGES (" + 
    			"imageid int NOT NULL AUTO_INCREMENT," +
    			"url VARCHAR(1000)," + 
    			"description VARCHAR(150)," +
    			"postUser VARCHAR(100) NOT NULL," + 
    			"postTimeStamp DATETIME DEFAULT CURRENT_TIMESTAMP," + 
    			"PRIMARY KEY(imageid)," +
    			"FOREIGN KEY (postUser) REFERENCES USERS(email))";
    	
    	connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql);
    }
    
    public void insertTenImages() throws SQLException{
    	String sql1 ="INSERT INTO Images" + 
    			"(url, description, postUser)" + 
    			"VALUES (\"https://images.unsplash.com/photo-1495567720989-cebdbdd97913?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1000&q=80\","
    			+ " \"Evening in Florida\", \"Diego@mail.com\")";
    	
    	String sql2 ="INSERT INTO Images" + 
    			"(url, description, postUser)" + 
    			"VALUES (\"https://theknow.denverpost.com/wp-content/uploads/2020/08/IMG_4252.jpg\","
    			+ " \"Denver’s last sunset before 5 pm\", \"Raymond@mail.com\")";
    	
    	String sql3 ="INSERT INTO Images" + 
    			"(url, description, postUser)" + 
    			"VALUES (\"https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/bb940ae6-edad-4ae2-bf22-a5d5e9e28267/dfuzbr-642aa2cc-620e-4afa-a608-f5b591ddba66.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvYmI5NDBhZTYtZWRhZC00YWUyLWJmMjItYTVkNWU5ZTI4MjY3XC9kZnV6YnItNjQyYWEyY2MtNjIwZS00YWZhLWE2MDgtZjViNTkxZGRiYTY2LmpwZyJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTpmaWxlLmRvd25sb2FkIl19.i-YdBoSeyxG6QvsZAi8oFdw69bdXOrJRQ5iUdq-3oGs\","
    			+ " \"pink, orange, purple sky day sunset\", \"Travis@mail.com\")";
    	
    	String sql4 ="INSERT INTO Images" + 
    			"(url, description, postUser)" + 
    			"VALUES (\"https://media.tegna-media.com/assets/AMAZELABS/images/67784454-d3b2-4870-8626-6b4c1f5f6c39/67784454-d3b2-4870-8626-6b4c1f5f6c39_1920x1080.jpeg\","
    			+ " \"the sky looks pink and orange\", \"Zara@mail.com\")";
    	
    	String sql5 ="INSERT INTO Images" + 
    			"(url, description, postUser)" + 
    			"VALUES (\"https://wi.wallpapertip.com/wsimgs/92-920937_beautiful-real-horizon-beautiful-sunset.jpg\","
    			+ " \"beautiful real horizon beautiful sunset\", \"Zaid@mail.com\")";
    	
    	String sql6 ="INSERT INTO Images" + 
    			"(url, description, postUser)" + 
    			"VALUES (\"https://images.pexels.com/photos/48207/sunset-sky-sun-cloud-48207.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260\","
    			+ " \"what gives a sunset its color?\", \"Ivy@mail.com\")";
    	
    	String sql7 ="INSERT INTO Images" + 
    			"(url, description, postUser)" + 
    			"VALUES (\"https://i.pinimg.com/originals/fc/83/af/fc83af98d44920a836408a17b2266148.jpg\","
    			+ " \"red sunset, ocean sunset\", \"Jessie@mail.com\")";
    	
    	String sql8 ="INSERT INTO Images" + 
    			"(url, description, postUser)" + 
    			"VALUES (\"https://pics.freeartbackgrounds.com/midle/Summer_Sunset_Background-392.jpg\","
    			+ " \"summer sunset\", \"Zavier@mail.com\")";
    	
    	String sql9 ="INSERT INTO Images" + 
    			"(url, description, postUser)" + 
    			"VALUES (\"https://images.fineartamerica.com/images-medium-large/red-sky-in-the-morning-steven-jt-wilson.jpg\","
    			+ " \"morning photograph\", \"Travis@mail.com\")";
    	
    	String sql10 ="INSERT INTO Images" + 
    			"(url, description, postUser)" + 
    			"VALUES (\"https://lh3.googleusercontent.com/proxy/aKVfflV1r68rMWUS2uHebstXT4dOp4j5gMaAwjSUcNhPJKmQ1Wo5PdTzPaj37JCAzCeopDsDvUKESg7jdvb_NSe24hdG5q62QxRiKNxKVfmSE9ibObz7Itc-EMqs\","
    			+ " \"sunset sky trees bushes clouds \", \"Zara@mail.com\")";
    	
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
    
    public boolean insertImage(images image) throws SQLException {
    	connect_func();         
		String sql = "insert into images (url, description, postUser) values (?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, image.url);
		preparedStatement.setString(2, image.description);
		preparedStatement.setString(3, image.postuser);
		
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        ResultSet resultset = preparedStatement.getGeneratedKeys();
        resultset.next();
        int imageid = resultset.getInt(1);
        System.out.println(imageid);
        image.setimageid(imageid);
        
        preparedStatement.close();
        return rowInserted;
    } 
    
    public List<images> listAllImages() throws SQLException{
    	List<images> listImages = new ArrayList<images>();
    	
    	String sql = "SELECT * FROM IMAGES ORDER BY imageid DESC";
    	
    	connect_func();
    	
    	statement = (Statement) connect.createStatement();
    	ResultSet resultset = statement.executeQuery(sql);
    	
    	while(resultset.next()) {
    		int imageid = resultset.getInt("imageid");
    		String url = resultset.getString("url");
    		String description = resultset.getString("description");
    		String postuser = resultset.getString("postUser");
    		
    		images image = new images(imageid, url, description, postuser);
    		listImages.add(image);
    	}
    	resultset.close();
        statement.close();         
        disconnect();        
        return listImages;
    }
    
    //-------------------------------//
    //ImageTags table here
    //-------------------------------//
    public void dropImageTagsTable() throws SQLException{
    	String sql = "DROP TABLE IF EXISTS IMAGETAGS";
    	connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql);
    }
    
    public void createImageTagsTable() throws SQLException{
    	String sql = "CREATE TABLE IMAGETAGS (" + 
    			"imageid int NOT NULL ," +
    			"tag VARCHAR(20) NOT NULL," + 
    			"PRIMARY KEY(imageid, tag)," +
    			"FOREIGN KEY (imageid) REFERENCES IMAGES(imageid))";
    	
    	connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql);
    }
    
    public void insertTenImageTags() throws SQLException{
    	String sql1 ="INSERT INTO IMAGETAGS" + 
    			"(imageid, tag)" + 
    			"VALUES (2,\"sunset\")";
    	
    	String sql2 ="INSERT INTO IMAGETAGS" + 
    			"(imageid, tag)" + 
    			"VALUES (2,\"sunset_hub\")";
    	
    	String sql3 ="INSERT INTO IMAGETAGS" + 
    			"(imageid, tag)" + 
    			"VALUES (4,\"photography\")";
    	
    	String sql4 ="INSERT INTO IMAGETAGS" + 
    			"(imageid, tag)" + 
    			"VALUES (3,\"nature\")";
    	
    	String sql5 ="INSERT INTO IMAGETAGS" + 
    			"(imageid, tag)" + 
    			"VALUES (7,\"sky\")";
    	
    	String sql6 ="INSERT INTO IMAGETAGS" + 
    			"(imageid, tag)" + 
    			"VALUES (5,\"landscape\")";
    	
    	String sql7 ="INSERT INTO IMAGETAGS" + 
    			"(imageid, tag)" + 
    			"VALUES (6,\"sunset_pics\")";
    	
    	String sql8 ="INSERT INTO IMAGETAGS" + 
    			"(imageid, tag)" + 
    			"VALUES (4,\"sunsets\")";
    	
    	String sql9 ="INSERT INTO IMAGETAGS" + 
    			"(imageid, tag)" + 
    			"VALUES (8,\"sunsetshot\")";
    	
    	String sql10 ="INSERT INTO IMAGETAGS" + 
    			"(imageid, tag)" + 
    			"VALUES (9,\"total_sunset\")";
    	
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
    
    public boolean insertImageTags(images image) throws SQLException {
    	connect_func();         
		String sql = "insert into imagetags (imageid, tag) values (?, ?)";
		
		String[] tags = image.gettags();
		
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		
		for (int i = 0; i < tags.length; i++) {
			
			preparedStatement.setInt(1, image.imageid);
			preparedStatement.setString(2, tags[i]);
			
	        boolean rowInserted = preparedStatement.executeUpdate() > 0;
		}
		
        preparedStatement.close();
        return true;
    } 
    
    
    //-------------------------------//
    //Comments table here
	//-------------------------------//
	public void dropCommentsTable() throws SQLException{
		String sql = "DROP TABLE IF EXISTS COMMENTS";
		connect_func();      
	    statement =  (Statement) connect.createStatement();
	    statement.executeUpdate(sql);
	}
    
	public void createCommentsTable() throws SQLException{
    	String sql = "CREATE TABLE COMMENTS (" + 
    			"email VARCHAR(100) NOT NULL ," +
    			"imageid int NOT NULL," + 
    			"description VARCHAR(500)," +
    			"PRIMARY KEY(email, imageid)," +
    			"FOREIGN KEY (email) REFERENCES USERS(email)," +
    			"FOREIGN KEY (imageid) REFERENCES IMAGES(imageid))";
    	
    	connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql);
    }
	
	public void insertTenComments() throws SQLException{
    	String sql1 ="INSERT INTO COMMENTS" + 
    			"(email, imageid, description)" + 
    			"VALUES (\"Diego@mail.com\", 3,\"How Beautiful!!\")";
    	
    	String sql2 ="INSERT INTO COMMENTS" + 
    			"(email, imageid, description)" + 
    			"VALUES (\"Eve@mail.com\", 5,\"Hey this is amazing\")";
    	
    	String sql3 ="INSERT INTO COMMENTS" + 
    			"(email, imageid, description)" + 
    			"VALUES (\"Travis@mail.com\", 2,\"Where is this?\")";
    	
    	String sql4 ="INSERT INTO COMMENTS" + 
    			"(email, imageid, description)" + 
    			"VALUES (\"Raymond@mail.com\", 9,\"Nice!\")";
    	
    	String sql5 ="INSERT INTO COMMENTS" + 
    			"(email, imageid, description)" + 
    			"VALUES (\"Zaid@mail.com\", 2,\"Is that near the beach?\")";
    	
    	String sql6 ="INSERT INTO COMMENTS" + 
    			"(email, imageid, description)" + 
    			"VALUES (\"Zara@mail.com\", 4,\"Beautiful picture\")";
    	
    	String sql7 ="INSERT INTO COMMENTS" + 
    			"(email, imageid, description)" + 
    			"VALUES (\"Jessie@mail.com\", 7,\"In love with this picture\")";
    	
    	String sql8 ="INSERT INTO COMMENTS" + 
    			"(email, imageid, description)" + 
    			"VALUES (\"Zavier@mail.com\", 6,\"We need to go here tomorrow\")";
    	
    	String sql9 ="INSERT INTO COMMENTS" + 
    			"(email, imageid, description)" + 
    			"VALUES (\"Diego@mail.com\", 10,\"Wonderful\")";
    	
    	String sql10 ="INSERT INTO COMMENTS" + 
    			"(email, imageid, description)" + 
    			"VALUES (\"Eve@mail.com\", 8,\"Breathtaking\")";
    	
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
	
	//-------------------------------//
    //Likes table here
	//-------------------------------//
	public void dropLikesTable() throws SQLException{
		String sql = "DROP TABLE IF EXISTS LIKES";
		connect_func();      
	    statement =  (Statement) connect.createStatement();
	    statement.executeUpdate(sql);
	}
	
	public void createLikesTable() throws SQLException{
    	String sql = "CREATE TABLE LIKES (" + 
    			"email VARCHAR(100) NOT NULL ," +
    			"imageid int NOT NULL," + 
    			"likedDate DATETIME DEFAULT CURRENT_TIMESTAMP," +
    			"PRIMARY KEY(email, imageid)," +
    			"FOREIGN KEY (email) REFERENCES USERS(email)," +
    			"FOREIGN KEY (imageid) REFERENCES IMAGES(imageid))";
    	
    	connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql);
    }
	
	public void insertTenLikes() throws SQLException{
    	String sql1 ="INSERT INTO LIKES" + 
    			"(email, imageid)" + 
    			"VALUES (\"Diego@mail.com\", 3)";
    	
    	String sql2 ="INSERT INTO LIKES" + 
    			"(email, imageid)" + 
    			"VALUES (\"Eve@mail.com\", 5)";
    	
    	String sql3 ="INSERT INTO LIKES" + 
    			"(email, imageid)" + 
    			"VALUES (\"Travis@mail.com\", 2)";
    	
    	String sql4 ="INSERT INTO LIKES" + 
    			"(email, imageid)" + 
    			"VALUES (\"Raymond@mail.com\", 6)";
    	
    	String sql5 ="INSERT INTO LIKES" + 
    			"(email, imageid)" + 
    			"VALUES (\"Zaid@mail.com\", 2)";
    	
    	String sql6 ="INSERT INTO LIKES" + 
    			"(email, imageid)" + 
    			"VALUES (\"Zara@mail.com\", 4)";
    	
    	String sql7 ="INSERT INTO LIKES" + 
    			"(email, imageid)" + 
    			"VALUES (\"Jessie@mail.com\", 7)";
    	
    	String sql8 ="INSERT INTO LIKES" + 
    			"(email, imageid)" + 
    			"VALUES (\"Zavier@mail.com\", 6)";
    	
    	String sql9 ="INSERT INTO LIKES" + 
    			"(email, imageid)" + 
    			"VALUES (\"Diego@mail.com\", 10)";
    	
    	String sql10 ="INSERT INTO LIKES" + 
    			"(email, imageid)" + 
    			"VALUES (\"Eve@mail.com\", 8)";
    	
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
    
    //Everything below from previous
    
    
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
         
    
}
