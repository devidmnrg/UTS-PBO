package UTS.Controller;

import UTS.Model.Story;
import UTS.Model.User;
import UTS.Model.Reel;
import UTS.Model.Comment;
import UTS.Model.Post;
import UTS.Model.ContentState;
import UTS.Model.ContentType;
import UTS.Model.Feed;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {

    ArrayList<Post> listPost = new ArrayList<Post>();
    ArrayList<User> listUser = new ArrayList<>();
    ArrayList<Comment> listComment = new ArrayList<Comment>();

    public void dataDummy() {

        // Data Dummy untuk User
        User user1 = new User("001", "devidmnrg", "pass123", "jomblo");
        User user2 = new User("002", "sam_kiel", "pass456", "jomblo ngenes");
        User user3 = new User("003", "tantan", "pass789", "hadehhh");

        listUser.add(user1);
        listUser.add(user2);

        Timestamp timestamp1 = Timestamp.valueOf("2023-10-10 23:59:59");
        Timestamp timestamp2 = Timestamp.valueOf("2022-01-05 10:10:00");
        Timestamp timestamp3 = Timestamp.valueOf("2021-11-12 12:12:12");

        Comment comment1 = new Comment("201", "Nice post!", ContentState.SHOWED);
        Comment comment2 = new Comment("202", "Awesome!", ContentState.SHOWED);
        listComment.add(comment1);
        listComment.add(comment2);

        // Reel
        Reel reel1 = new Reel(15, 200, "301", ContentState.SHOWED, timestamp1, ContentType.VIDEO);
        Reel reel2 = new Reel(10, 150, "302", ContentState.ARCHIVED, timestamp2, ContentType.VIDEO);

        // Story
        Story story1 = new Story(30, 100, "401", ContentState.SHOWED, timestamp1, ContentType.VIDEO);
        Story story2 = new Story(20, 50, "402", ContentState.ARCHIVED, timestamp3, ContentType.PICTURE);

        // Feed
        Feed feed1 = new Feed("Amazing view!", 200, "501", ContentState.SHOWED, timestamp2, ContentType.PICTURE);
        Feed feed2 = new Feed("Fun times!", 150, "502", ContentState.ARCHIVED, timestamp3, ContentType.PICTURE);

        listPost.add(story1);
        listPost.add(story2);
        listPost.add(reel1);
        listPost.add(reel2);
        listPost.add(feed1);
        listPost.add(feed2);
    }

    //Nomor 1
    public void showUserPosts() {
        ArrayList<Post> sortedPosts = new ArrayList<>(listPost); // Salin listPost ke sortedPosts

        Collections.sort(sortedPosts, (post1, post2) -> {
            ContentState state1 = post1.getStatus();
            ContentState state2 = post2.getStatus();

            if (state1 != state2) {
                List<ContentState> order = List.of(ContentState.PINNED, ContentState.SHOWED, ContentState.ARCHIVED,
                        ContentState.DELETED);
                return order.indexOf(state1) - order.indexOf(state2);
            } else {
                return post2.getTimeUpload().compareTo(post1.getTimeUpload());
            }
        });

        int deletedPostCount = 0;
        for (Post post : sortedPosts) {
            ContentState state = post.getStatus();
            if (state == ContentState.DELETED) {
                deletedPostCount++;
            } else {
                if (post instanceof Reel) {
                    Reel reel = (Reel) post;
                    System.out.println("Post ID: " + reel.getPostId()
                            + ", Status: " + reel.getStatus()
                            + ", Type: " + reel.getPostType()
                            + ", Time Upload: " + reel.getTimeUpload()
                            + ", Play Count: " + reel.getPlayedCount());
                } else if (post instanceof Feed) {
                    Feed feed = (Feed) post;
                    System.out.println("Post ID: " + feed.getPostId()
                            + ", Status: " + feed.getStatus()
                            + ", Type: " + feed.getPostType()
                            + ", Time Upload: " + feed.getTimeUpload()
                            + ", Likes: " + feed.getLikes());
                } else if (post instanceof Story) {
                    Story story = (Story) post;
                    System.out.println("Post ID: " + story.getPostId()
                            + ", Status: " + story.getStatus()
                            + ", Type: " + story.getPostType()
                            + ", Time Upload: " + story.getTimeUpload()
                            + ", Views: " + story.getViews());
                }
            }
        }
        System.out.println("Number of deleted posts: " + deletedPostCount);
    }

    //Nomor 2
    public void showPost(String postId) {
        boolean postFound = false;
        for (int i = 0; i < listPost.size(); i++) {
            Post post = listPost.get(i);
            if (post.getPostId().equals(postId)) {
                postFound = true;
                if (post instanceof Reel) {
                    Reel reel = (Reel) post;
                    System.out.println("Reel Details:");
                    System.out.println("Post ID: " + reel.getPostId());
                    System.out.println("Status: " + reel.getStatus());
                    System.out.println("Type: " + reel.getPostType());
                    System.out.println("Time Upload: " + reel.getTimeUpload());
                    System.out.println("Play Count: " + reel.getPlayedCount());
                } else if (post instanceof Feed) {
                    Feed feed = (Feed) post;
                    System.out.println("Feed Details:");
                    System.out.println("Post ID: " + feed.getPostId());
                    System.out.println("Status: " + feed.getStatus());
                    System.out.println("Type: " + feed.getPostType());
                    System.out.println("Time Upload: " + feed.getTimeUpload());
                    System.out.println("Likes: " + feed.getLikes());
                } else if (post instanceof Story) {
                    Story story = (Story) post;
                    System.out.println("Story Details:");
                    System.out.println("Post ID: " + story.getPostId());
                    System.out.println("Status: " + story.getStatus());
                    System.out.println("Type: " + story.getPostType());
                    System.out.println("Time Upload: " + story.getTimeUpload());
                    System.out.println("Views: " + story.getViews());
                }
                break;
            }
        }
        if (!postFound) {
            System.out.println("Post dengan ID " + postId + " tidak ditemukan.");
        }
    }

    //Nomor 3
    public void changePostState(Post post, ContentState newStatus) {
        if (!listPost.contains(post)) {
            System.out.println("Postingan tersebut tidak tersedia.");
            return;
        }

        ContentState currentStatus = post.getStatus();
        ContentType postType = post.getPostType();

        if (currentStatus == newStatus) {
            System.out.println("Post sudah berada dalam status yang diinginkan.");
            return;
        }

        switch (currentStatus) {
            case SHOWED:
                if (newStatus == ContentState.ARCHIVED || newStatus == ContentState.PINNED) {
                    post.setStatus(newStatus);
                    System.out.println("Status post telah diubah ke-" + newStatus);
                }
                break;
            case ARCHIVED:
                if (newStatus == ContentState.DELETED) {
                    post.setStatus(newStatus);
                    System.out.println("Status post telah diubah ke-" + newStatus);
                }
                break;
            case PINNED:
                if (postType == ContentType.PICTURE && newStatus == ContentState.SHOWED) {
                    int pinnedCount = countPinnedFeeds();
                    if (pinnedCount < 3) {
                        post.setStatus(newStatus);
                        System.out.println("Status post telah diubah ke-" + newStatus);
                    } else {
                        System.out.println("Kamu sudah mengePIN 3 postingan");
                    }
                }
                break;
            default:
                System.out.println("Gagal Merubah Status!");
        }
    }

    private int countPinnedFeeds() {
        int pinnedCount = 0;
        for (Post p : listPost) {
            if (p.getPostType() == ContentType.PICTURE && p.getStatus() == ContentState.PINNED) {
                pinnedCount++;
            }
        }
        return pinnedCount;
    }

}
