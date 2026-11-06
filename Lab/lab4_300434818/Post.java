import java.util.Calendar;
import java.util.Date;

public class Post implements Likeable, Comparable<Post> {
    protected int likes;                 // Number of likes
    private Date timeStamp;              // Timestamp of post creation
    private String userName;             // Username of the poster

    // Constructor initializes the post with username and current timestamp
    public Post(String userName) {
        this.userName = userName;
        this.timeStamp = Calendar.getInstance().getTime(); // Current date and time
        this.likes = 0;                                   // Default like count
    }

    public String getUserName() {
        return userName;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    // Implementation of Likeable interface
    public void like() {
        likes++; // Increment like count
    }

    public int getLikes() {
        return likes; // Return current like count
    }

    public int compareTo(Post other) {
        return this.timeStamp.compareTo(other.timeStamp); // Compare posts based on timestamp
    }

    public boolean isPopular() {
        return likes > 100; // A post is popular if it has more than 100 likes
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
    }
}
