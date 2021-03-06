
public class User {
    protected String email;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String gender;
    protected int age;
    protected int numFollowers;
    protected int numFollowings;
 
    public User() {
    }
 
    /*public User(String email) {
        this.email = email;
    }
 
    public User(String email, String firstName, String lastName, char gender, DateFormat birthday, int numFollowers, int numFollowings) {
        this(email, address, status);
        this.id = id;
    }*/
     
    public User(String email, String password, String firstName, String lastName, String gender, int age) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }
    
    public User(String email, String firstName, String lastName, String gender, int age, int numFollowers, int numFollowings) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.numFollowers = numFollowers;
        this.numFollowings = numFollowings;
    }
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getGender() {
        return gender;
    }
 
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public int getAge() {
    	return age;
    }
    
    public void setAge(int age) {
    	this.age = age;
    }
    
    public int getNumFollowers(){
    	return numFollowers;
    }
    
    public void setNumFollowers(int numFollowers) {
    	this.numFollowers = numFollowers;
    }
    
    public int getNumFollowings() {
    	return numFollowings;
    }
    
    public void setNumFollowings(int numFollowings) {
    	this.numFollowings = numFollowings;
    }
 
    
}