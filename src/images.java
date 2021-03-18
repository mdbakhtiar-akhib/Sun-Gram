import java.text.DateFormat;

public class images {
    protected int imageid;
    protected String url;
    protected String description;
    protected String postuser;
    protected static DateFormat Datetime;
    
 
    public images() {
    }
 
    public images(int imageid) {
        this.imageid = imageid;
    }
 
    public images(int imageid, String url, String description, String postuser, DateFormat Fatetime) {
        this(url, description, postuser, Datetime);
        this.imageid = imageid;
    }
     
    public images(String url, String description, String postuser, DateFormat Datetime) {
        this.url = url;
        this.description = description;
        this.postuser = postuser;
        this.Datetime = Datetime;
    }
 
    public int getimageid() {
        return imageid;
    }
 
    public void setimageid(int imageid) {
        this.imageid = imageid;
    }
 
    public String geturl() {
        return url;
    }
 
    public void seturl(String url) {
        this.url = url;
    }
 
    public String getdescription() {
        return description;
    }
 
    public void setdescription(String description) {
        this.description = description;
    }
 
    public String getpostuser() {
        return postuser;
    }
 
    public void setpostuser(String postuser) {
        this.postuser = postuser;
    }
    
    public DateFormat getDatetime() {
        return Datetime;
    }
 
    public void setDatetime(DateFormat Datetime) {
        this.Datetime = Datetime;
    }
    
}