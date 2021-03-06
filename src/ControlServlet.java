import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private ImagesDAO imagesDAO;
    private HttpSession session = null;
 
    public void init() { 
        userDAO = new UserDAO();
        imagesDAO = new ImagesDAO();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
            
            case "/root":
            	initializeDatabase(request, response);
            	break;
            case "/register":
            	registerUser(request, response);
            	break;
            case "/login":
            	loginUser(request, response);
            	break;
            case "/feed":
            	feedViewer(request, response);
            	break;
            case "/feedRoot":
            	feedRootViewer(request, response);
            	break;
            case "/PostImage":
            	postImage(request, response);
            	break;
            case "/Profile":
            	userProfile(request, response);
            	break;
            }   
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    
    private void initializeDatabase(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	
        imagesDAO.dropImageTagsTable();
        imagesDAO.dropCommentsTable();
        imagesDAO.dropLikesTable();
        userDAO.dropFollowTable();
        imagesDAO.dropImagesTable();
        userDAO.dropUserTable();
        
        userDAO.createUserTable();
        userDAO.insertTenUsers();
        
        imagesDAO.createImagesTable();
        imagesDAO.insertTenImages();
        
        
        imagesDAO.createImageTagsTable();
        imagesDAO.insertTenImageTags();
        
        
        imagesDAO.createCommentsTable();
        imagesDAO.insertTenComments();
        
        
        imagesDAO.createLikesTable();
        imagesDAO.insertTenLikes();
        
        
        userDAO.createFollowTable();
        userDAO.insertTenFollow();
              
        response.sendRedirect("feedRoot");
    }
    
    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	PrintWriter out = response.getWriter();
    	
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	String firstName = request.getParameter("fname");
    	String lastName = request.getParameter("lname");
    	String gender = request.getParameter("gender");
    	int age = Integer.parseInt(request.getParameter("age"));
    	
    	boolean inValidEmail = userDAO.checkEmail(email);
    	
    	if(inValidEmail) {
    		out.print("<script>alert('Registrations failed, User already exists. Try another Email');window.location='RegisterUser.jsp'</script>");
    	}
    	
    	else {
    		User newUser = new User(email, password, firstName, lastName, gender, age);
        	
        	userDAO.registerUser(newUser);
        	
        	response.sendRedirect("feed");
    	}
    	
    }
    
    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	
    	PrintWriter out = response.getWriter();
    	boolean userExists;
        
        String Email = request.getParameter("email");
        String password = request.getParameter("password");
           
        User user = new User(Email, password);
        
        userExists = userDAO.loginUser(user);
        
        if(userExists) {
        	user = userDAO.getUser(Email);
        	System.out.println(user.getEmail());
        	session= request.getSession();
        	session.setAttribute("currentUser", user.getEmail());
        	session.setAttribute("currentUserFname", user.getFirstName());
        	session.setAttribute("currentUserLname", user.getLastName());
        	if(Email.contentEquals("root")){
        		response.sendRedirect("feedRoot");
        	}
        	else {
        		response.sendRedirect("feed");
        	}
        }
        
        else {
        	out.print("<script>alert('Log in failed, Wrong Username or Password.');window.location='LogIn.jsp'</script>");
        }
    }
    
    private void feedViewer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	List<images> listImages = imagesDAO.listAllImages();
    	request.setAttribute("listImages", listImages);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("FeedPage.jsp");
        dispatcher.forward(request, response);
    }
    
    private void feedRootViewer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("FeedPageRoot.jsp");
        dispatcher.forward(request, response);
    }
    
    private void postImage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	PrintWriter out = response.getWriter();
    	
    	String userID = request.getParameter("Userid");
    	String url = request.getParameter("url");
    	String tags = request.getParameter("tags");
    	String description = request.getParameter("description");
    	
    	String[] tagsSplitted = tags.split(", ");
    		
    	images newImage = new images(url, description, userID, tagsSplitted);
    	
    	boolean success = imagesDAO.insertImage(newImage);
    	
    	
    	if(success) {
    		imagesDAO.insertImageTags(newImage);
    		response.sendRedirect("feed");
    	}
    	else {
    		out.print("<script>alert('Image posting failed, please try again');window.location='PostImage.jsp'</script>");
    	}
    	
    }
    
    private void userProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	String Email = request.getParameter("email");
    	System.out.println("I am in line 212" + Email);
    	User user = userDAO.getUser(Email);
    	System.out.println("I am in line 214 " + user.email);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("Profile.jsp");
    	request.setAttribute("user", user);
        dispatcher.forward(request, response);
    }

}