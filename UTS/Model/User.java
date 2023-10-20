package UTS.Model;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String username;
    private String password;
    private String bio;
    private ArrayList<Post> postingan = new ArrayList<Post>();

    public User(String userId, String username, String password, String bio) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.bio = bio;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<Post> getPostingan() {
        return postingan;
    }

    public void setPostingan(ArrayList<Post> postingan) {
        this.postingan = postingan;
    }

    public ArrayList<Post> getPostId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
