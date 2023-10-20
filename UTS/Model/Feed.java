package UTS.Model;

import java.sql.Timestamp;

public class Feed extends Post{
    private String caption;
    private int likes;
    public Feed(String caption, int likes, String postId, ContentState status, Timestamp timeUpload, ContentType postType) {
        super(postId, status, timeUpload, postType);
        this.caption = caption;
        this.likes = likes;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    
}
