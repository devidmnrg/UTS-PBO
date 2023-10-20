package UTS.Model;

import java.sql.Timestamp;

public class Reel extends Post{
    private int duration;
    private int playedCount;

    public Reel(int duration, int playedCount, String postId, ContentState status, Timestamp timeUpload, ContentType postType) {
        super(postId, status, timeUpload, postType);
        this.duration = duration;
        this.playedCount = playedCount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPlayedCount() {
        return playedCount;
    }

    public void setPlayedCount(int playedCount) {
        this.playedCount = playedCount;
    }
}
