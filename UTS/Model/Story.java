package UTS.Model;

import java.sql.Timestamp;

public class Story extends Post {
    private int duration;
    private int views;

    public Story(int duration, int views, String postId, ContentState status, Timestamp timeUpload, ContentType postType) {
        super(postId, status, timeUpload, postType);
        this.duration = duration;
        this.views = views;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
