package UTS.Model;
import java.sql.Timestamp;
import java.util.ArrayList;
public abstract class Post {
    private String postId;
    private ContentState status;
    private Timestamp timeUpload;
    private ContentType postType;
    private ArrayList<Comment> comment = new ArrayList<Comment>();

    public Post(String postId, ContentState status, Timestamp timeUpload, ContentType postType) {
        this.postId = postId;
        this.status = status;
        this.timeUpload = timeUpload;
        this.postType = postType;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public ContentState getStatus() {
        return status;
    }

    public void setStatus(ContentState status) {
        this.status = status;
    }

    public Timestamp getTimeUpload() {
        return timeUpload;
    }

    public void setTimeUpload(Timestamp timeUpload) {
        this.timeUpload = timeUpload;
    }

    public ContentType getPostType() {
        return postType;
    }

    public void setPostType(ContentType postType) {
        this.postType = postType;
    }

    public ArrayList<Comment> getComment() {
        return comment;
    }

    public void setComment(ArrayList<Comment> comment) {
        this.comment = comment;
    }
}
